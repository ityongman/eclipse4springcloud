package com.ityongman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {
	@Autowired
	private RestTemplate restTemplate ;
	
	@HystrixCommand(fallbackMethod="addServiceFallBack")
	public String addService() {
		return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=15&b=20", String.class).getBody();
	}
	
	public String addServiceFallBack() {
		return "error";
	}
}
