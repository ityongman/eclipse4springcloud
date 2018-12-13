package com.ityongman.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
	
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext() ;
		HttpServletRequest request = context.getRequest() ;
		
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		String accessToken = request.getParameter("accessToken");
		if(null == accessToken) {
			log.warn("access token is empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			
			return "accessToken is empty" ;
		}
		log.info("access token ok");
		
		return "accessToken not empty";
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
