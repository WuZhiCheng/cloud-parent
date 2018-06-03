package com.example.serviceb.service;

import org.springframework.beans.factory.annotation.Value;
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
    public String home(@RequestParam String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(	"hi:"+name);
        return "hi "+name+",i am from port:" +port;
    }
}
