package com.promineo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{


	public String resourceName;
	public String fieldName;
	
	private Object findValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object findValue) {
	super(String.format("%s not found with %s: '%s'", resourceName, fieldName, findValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.findValue = findValue;
}
public String gerResourceName() {
	return resourceName;
	
}
public String getFieldname() {
	return fieldName;
}
public Object getFindValue() {
	return findValue;
}

}
