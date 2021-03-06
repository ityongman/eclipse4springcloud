package com.ityongman.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ComputeController {
	private final Logger log = Logger.getLogger(getClass());
	@Autowired
	private DiscoveryClient client ;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = client.getLocalServiceInstance();
		log.info("/add , host " +instance.getHost()+ ", service_id : " + instance.getServiceId() 
			+ ", service port : "+ instance.getPort() +", result is "+(a + b));
		
		return a + b ;
	}
}
