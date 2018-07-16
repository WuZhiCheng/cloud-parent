package com.example.servicea.service;

import com.example.common.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:30 2018/5/30
 * @company:北京今汇在线
 */
@RestController
public class HelloService {
    
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
//    public String home(@RequestParam String name) {
    public String home(@RequestBody String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(	"hi:"+name);
        return "hi "+name+",i am from port:" +port;
    }


    @RequestMapping("/user")
//    public String home(@RequestParam String name) {
    public String user(@RequestBody User user) {
    /*    try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int a = 0;
        System.out.println(2/a);
        System.out.println(	"hi:"+user);
        return "hi "+user+",i am from port:" +port;
    }


}



