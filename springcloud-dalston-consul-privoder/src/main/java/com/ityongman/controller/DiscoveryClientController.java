package com.ityongman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryClientController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/getDc")
	public String findDiscoveryClient() {
		String services = "services : " + discoveryClient.getServices().toString() ;
		System.out.println(services + "2222");
		
		return services ;
	}
}
