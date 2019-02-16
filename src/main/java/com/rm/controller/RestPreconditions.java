package com.rm.controller;

public class RestPreconditions {
	
	public static <T> T checkFound(T resource){
		if(resource == null){
			throw new ResourceNotFoundException();
		}
		
		return resource;
	}
}
