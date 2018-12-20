package com.ityongman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoveryConsumerController {
	@Value("${consul.provider}")
	private String consulProvider ;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getConsumer")
	public String getDiscoveryConsumer() {
		ServiceInstance instance = loadBalancerClient.choose(consulProvider);
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getDc"; 
		System.out.println(url);
		
		return restTemplate.getForObject(url, String.class) ;
	}
}
