package com.example.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：趴取网页上的今天的天气
 * @author     zjm
 * @time     2014/8/6
 */
public class TodayTemperatureService {

    //爬取链接 http://www.8btc.com/what-is-blockchain
    // String regex = "(http|https)://[\\w+\\.?/?]+\\.[A-Za-z]+";
    public static void spiderURL(String url,String regex,String filename){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        String time=sdf.format(new Date());
        URL realURL=null;
        URLConnection connection=null;
        BufferedReader br=null;
        PrintWriter pw=null;
        PrintWriter pw1=null;

        Pattern pattern=Pattern.compile(regex);
        try{
            realURL=new URL(url);
            connection=realURL.openConnection();
            File fileDir = new File("D:/spider/"+time);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            //将爬取到的内容放到E盘相应目录下
            pw = new PrintWriter(new FileWriter("D:/spider/"+time+"/"+filename+"_content.txt"),true);
            pw1 = new PrintWriter(new FileWriter("D:/spider/"+time+"/"+filename+"_URL.txt"),true);

            br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while((line=br.readLine())!=null){
                pw.println(line);
                Matcher matcher=pattern.matcher(line);
                while(matcher.find()){
                    pw1.println(matcher.group());
                }

            }
            System.out.println("爬取成功！");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                br.close();
                pw.close();
                pw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void main(String[] args) {
        String url="https://mp.weixin.qq.com/s?__biz=MzAxOTc0NzExNg==&mid=2665513059&idx=1&sn=a2eaf97d9e3000d15a33681d1b720463&scene=21#wechat_redirect";
        String regex= "(http|https)://[\\w+\\.?/?]+\\.[A-Za-z]+";
        spiderURL(url,regex,"8btc");
    }

}
