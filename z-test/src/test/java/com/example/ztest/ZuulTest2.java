package com.example.ztest;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

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
public class ZuulTest2 {

    public static void main(String[] args) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        int num82 = 0;
        int num83 = 0;
        int errorNum = 0;
        HashMap<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            paramMap.put("name", "哈哈"+i);
            try {
                String result3= HttpUtil.get("http://localhost:8769/consume/hi", paramMap);
                if(result3.contains("8763")){
                    num83++;
                }else if(result3.contains("8762")){
                    num82++;
                }
                System.out.println(result3);
            } catch (Exception e) {
                e.printStackTrace();
                errorNum++;
            }
        }

        System.out.println(num82+",,"+num83+",,"+errorNum);

    }
}
