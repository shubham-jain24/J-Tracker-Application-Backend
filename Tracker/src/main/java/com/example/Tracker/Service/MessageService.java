package com.example.Tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tracker.Entity.MessageBean;

@Service
public class MessageService {
	@Autowired
	MessageBean messageBean;
	
	public MessageService() {
		super();
	}
	public String getMessage() {
		return messageBean.getMessage();
	}
	public void setMessage(String message) {
		this.messageBean.setMessage(message);
	}
}
