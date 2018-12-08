package com.ityongman;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现； 
 * 2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 * 
 * @author ityongman
 */
@EnableEurekaClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
			.web(true)
			.run(args);
	}
}
