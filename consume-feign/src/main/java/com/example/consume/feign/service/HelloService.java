package com.example.consume.feign.service;

import com.example.common.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 10:50 2018/5/6/006
 * @company:北京今汇在线           Factory
 */
@FeignClient(value="SERVICE-HI",fallback = HelloServiceFallback.class)
public interface HelloService {
    
    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "defaultStores")
    public String hiService(@RequestBody String name);

    @GetMapping("/user")
    public String userService(@RequestBody User user);

}
