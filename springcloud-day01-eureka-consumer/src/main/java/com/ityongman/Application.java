package com.ityongman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate(); // 注册生成负载均衡模板
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
