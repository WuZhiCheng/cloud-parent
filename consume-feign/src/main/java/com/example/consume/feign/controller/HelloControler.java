package com.example.consume.feign.controller;

import com.example.common.pojo.User;
import com.example.consume.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 10:51 2018/5/6/006
 * @company:北京今汇在线
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return "HelloControler:::::"+helloService.hiService(name);
    }

    @RequestMapping(value = "/user")
    public String user(@RequestParam String name){
        User u = new User();
        u.setName(name);
        u.setPass(UUID.randomUUID().toString());
        return "HelloControler:::::"+helloService.userService(u);
    }


}
