package com.example.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 9:04 2018/7/8/008
 * @company:北京今汇在线
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${id}")
    private String id;

    @Value("${desc}")
    private String desc;

    @Value("${db}")
    private String db;

    @RequestMapping("/test")
    public String test() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "id:" + id + " desc:" + desc + " db:" + db;
    }
}
