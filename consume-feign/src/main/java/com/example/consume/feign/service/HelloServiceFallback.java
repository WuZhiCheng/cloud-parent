package com.example.consume.feign.service;

import com.example.common.pojo.User;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:18 2018/7/13
 * @company:北京今汇在线
 */
@Component
public class HelloServiceFallback  implements HelloService  {
    @Override
    public String hiService(String name) {
        return "HelloServiceFallback";
    }

    @Override
    public String userService(User user) {
        return "userServiceFallback";
    }
}
