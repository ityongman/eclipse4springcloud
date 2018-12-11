package com.ityongman.client.impl;

import org.springframework.stereotype.Component;

import com.ityongman.client.ComputeClient;

@Component
public class ComputeClientHystrix implements ComputeClient{

	@Override
	public Integer add(Integer a, Integer b) {
		return -9999;
	}

}
