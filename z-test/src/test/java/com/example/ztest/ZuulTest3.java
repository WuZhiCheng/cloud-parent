package com.example.ztest;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 8:48 2018/6/5
 * @company:北京今汇在线
 */
public class ZuulTest3 {

    public static void main(String[] args) throws Exception{
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        final AtomicInteger num82 = new AtomicInteger(0);
        final AtomicInteger num83 = new AtomicInteger(0);
        final AtomicInteger errorNum = new AtomicInteger(0);

        final AtomicInteger num82Total = new AtomicInteger(0);
        final AtomicInteger num83Total = new AtomicInteger(0);
        final AtomicInteger errorNumTotal = new AtomicInteger(0);


//        配置zuul的tomcat

        HashMap<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int num = 300;
            CountDownLatch countDownLatch = new CountDownLatch(num);
            for (int j = 0; j < num; j++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        paramMap.put("name", "哈哈"+System.currentTimeMillis());
                        try {
                            String result3= HttpUtil.get("http://localhost:8769/consume/hi", paramMap);
                            if(result3.contains("8763")){
                                num83.addAndGet(1);
                                num83Total.addAndGet(1);

                            }else if(result3.contains("8762")){
                                num82.addAndGet(1);
                                num82Total.addAndGet(1);
                            }else{
                                errorNum.addAndGet(1);
                                errorNumTotal.addAndGet(1);
                            }
//                            System.out.println(result3);
                        } catch (Exception e) {
                            e.printStackTrace();
                            errorNum.addAndGet(1);
                        }
                    }
                }).start();
                countDownLatch.countDown();
            }

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i>=1){
                System.out.println("result::::"+num82+",,"+num83+",,"+errorNum);
            }
            num82.set(0);
            num83.set(0);
            errorNum.set(0);
            if (i==0){
                num82Total.set(0);
                num83Total.set(0);
                errorNumTotal.set(0);
            }
    }
        Thread.sleep(30000);
        System.out.println("resultTotal::::"+num82Total+",,"+num83Total+",,"+errorNumTotal);

    }


}
