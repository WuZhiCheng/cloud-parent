package com.example.consumea;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
//@EnableHystrixDashboard
public class ConsumeAApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
//		com.netflix.loadbalancer.WeightedResponseTimeRule
		return new RestTemplate();
	}
//https://blog.csdn.net/rickiyeat/article/details/64918756
/*	@Bean
	public IRule ribbonRule() {
		//这里配置策略，和配置文件对应
		return new RandomRule();
//		return new WeightedResponseTimeRule();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ConsumeAApplication.class, args);
	}


	//	Hystrix 仪表盘
	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
