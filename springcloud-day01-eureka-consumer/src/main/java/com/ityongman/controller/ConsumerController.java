package com.ityongman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ityongman.service.ComputeService;

@RestController
public class ConsumerController {
	@Value("${service.provider.name}")
	private String serviceProvider ;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	@Autowired
	private ComputeService computeService ;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return restTemplate.getForEntity(serviceProvider+"/add?a=10&b=20" , String.class).getBody();
	}
	
	@RequestMapping(value="/add2", method=RequestMethod.GET)
	public String add2() {
		return computeService.addService();
	}
}
