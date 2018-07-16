package com.example.consumea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
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
 * @company:北京今汇在线
 */
@Service
public class HelloService {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    /** 未配置断路器*/
    public String hiService(String name) {
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-hi");
//        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
//                + serviceInstance.getPort());// 打印当前调用服务的信息
        return restTemplate.getForObject("http://SERVICE-HI/hi" +
                "?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
