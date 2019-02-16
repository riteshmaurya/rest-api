package com.rm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		//TODO 401 is sent without the WWW-Authenticate header, as required by the HTTP Spec. We can, of course, set the value manually if we need to.
		//response.addDateHeader("WWW-Authenticate", arg1);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Go to hell");
			
		
	}

}
