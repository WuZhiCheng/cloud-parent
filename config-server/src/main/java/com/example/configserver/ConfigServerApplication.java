package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigServerApplication {
//https://blog.csdn.net/fox9916/article/details/79499854/
//	https://www.cnblogs.com/luangeng/p/7252665.html
//	http://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.0.0.RELEASE/single/spring-cloud-config.html#_spring_cloud_config_client
//	访问：http://localhost:8080/config-dev/pro
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
