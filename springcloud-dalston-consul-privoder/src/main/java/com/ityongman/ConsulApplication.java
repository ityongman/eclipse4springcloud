package com.ityongman;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulApplication.class)
			.web(true)
			.run(args);
	}
}
