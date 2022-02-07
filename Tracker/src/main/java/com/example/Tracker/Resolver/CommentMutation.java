package com.example.Tracker.Resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Entity.Comments;
import com.example.Tracker.Service.CommentService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class CommentMutation implements GraphQLMutationResolver {
	
	@Autowired
	CommentService serv;
	
	public String addComment(String sourceId, String commentDescription, String commentCreationDate, String commentEditDate) {
		Comments c = new Comments();
		c.setSourceId(sourceId);
		c.setCommentDescription(commentDescription);
		c.setCommentCreationDate(commentCreationDate);
		c.setCommentEditDate(commentEditDate);
		
		return serv.addComment(c);
		
	}

}
