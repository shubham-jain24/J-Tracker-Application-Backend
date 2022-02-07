package com.example.Tracker.Resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Service.MessageService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class MessageQuery implements GraphQLQueryResolver {
	@Autowired
	MessageService messageservice;
//The code that gets invoked for message query in schema file
	public String getMessage() {
		return messageservice.getMessage();
	}
}