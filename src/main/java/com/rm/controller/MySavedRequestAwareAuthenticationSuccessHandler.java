package com.rm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

@Configuration
public class MySavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private RequestCache requestCache = new HttpSessionRequestCache();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if(savedRequest == null){
			clearAuthenticationAttributes(request);
			return;
		}
		String targetUrlParam = getTargetUrlParameter();
		if(isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParam != null
				&& StringUtils.hasText(request.getParameter(targetUrlParam)))){
			requestCache.removeRequest(request, response);
			return;
		}
		
		clearAuthenticationAttributes(request);
	}
	
	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
