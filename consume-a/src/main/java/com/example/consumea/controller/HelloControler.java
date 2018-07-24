package com.example.consumea.controller;

import com.example.consumea.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /** 先调用zuul，再转发到service*/
    @RequestMapping(value = "/hiZul")
    public String hiZul(@RequestParam String name){
        return "HelloControler:::::"+helloService.hiServiceZuul(name+"  zuul");
    }


}
