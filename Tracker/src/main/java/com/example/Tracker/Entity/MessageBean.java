package com.example.Tracker.Entity;

import org.springframework.stereotype.Component;

@Component
public class MessageBean {
	public MessageBean()
	{ 
		this.message="Hello!";
	}
	String message;
   
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}