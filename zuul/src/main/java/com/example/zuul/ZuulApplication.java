package com.example.zuul;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {


	/*zuul里只添加@Bean注解 可以达到负载均衡效果，不需要配置文件配置

	consume-a 只需要配置文件配置，不用注解@Bean*/
		@Bean
	public IRule ribbonRule() {
		//这里配置策略，和配置文件对应
//		return new RandomRule();
		return new WeightedResponseTimeRule();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
