package com.example.servicea.service;

import com.example.common.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod="helloFallbackMethod")/*调用方式失败后调用helloFallbackMethod*/
    @RequestMapping("/hiZuul")
    public String homeRequestParamZuul(@RequestParam String name) {
        return "hi "+name+",i am param  from Zuul port:" +port;
    }

    @HystrixCommand(fallbackMethod="helloFallbackMethod")/*调用方式失败后调用helloFallbackMethod*/
    @RequestMapping("/hip")
    public String homeRequestParam(@RequestParam String name) {
        return "hi "+name+",i am param from port:" +port;
    }

    @HystrixCommand(fallbackMethod="helloFallbackMethod")/*调用方式失败后调用helloFallbackMethod*/
    @RequestMapping("/hi")
    public String home(@RequestBody String name) {
     /*   try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     */
        if("1".equals(name)){
            throw new RuntimeException("...");
        }
        System.out.println(	"hi:"+name);
        return "hi "+name+",i am from port:" +port;
    }


    @HystrixCommand(fallbackMethod="userFallbackMethod")
    @RequestMapping("/user")
    public String user(@RequestBody User user) {
        int a = 0;
        System.out.println(2/a);
        System.out.println(	"hi:"+user);
        return "hi "+user+",i am from port:" +port;
    }
      /**,Throwable e 为可选参数*/
    public String helloFallbackMethod(String fallback, Throwable e){
            return "fallback 参数值为:" + fallback;
        }
    public String userFallbackMethod(User user, Throwable e){
        return "fallback 参数值为:"+user+"  fail reason:"+e;
    }
}
