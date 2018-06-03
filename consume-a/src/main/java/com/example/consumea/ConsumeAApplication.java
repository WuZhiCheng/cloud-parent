package com.example.consumea;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumeAApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
//		com.netflix.loadbalancer.WeightedResponseTimeRule
		return new RestTemplate();
	}
//https://blog.csdn.net/rickiyeat/article/details/64918756
	@Bean
	public IRule ribbonRule() {
		//这里配置策略，和配置文件对应
//		return new RandomRule();
		return new WeightedResponseTimeRule();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumeAApplication.class, args);
	}
}
