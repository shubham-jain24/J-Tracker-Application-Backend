package com.example.Tracker.Resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Entity.Comments;
import com.example.Tracker.Entity.UserStory;
import com.example.Tracker.Service.CommentService;
import com.example.Tracker.Service.UserStoryService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class UserStoryQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	UserStoryService serv;
	@Autowired
	CommentService commServ;
	
	public List<UserStory> getUserStory(){
		return serv.getUserStory();
	}
	
	public Optional<UserStory> getUserStoryByID(String id) {
		
		Optional<UserStory> userStory =  serv.findUserStoryById(id);
		if(userStory.isPresent()) {
			List<Comments> usCommentList = commServ.getAllCommennts(userStory.get().getUserStoryId());
			userStory.get().setComments(usCommentList);
		}
		return userStory;
	}
	
	public Optional<List<UserStory>> getUserStoryByFilter(String ownerName, String assignedName, String status){
		if (ownerName != null && assignedName!=null && status!= null) {
			return serv.findByUserStoryOwnerAndStatusAndAssigned(ownerName, assignedName, status);
		}
		else if (ownerName != null && assignedName!= null) {
			return serv.findByUserStoryOwnerAndAssigned(ownerName, assignedName);
		}
		else if (status != null && assignedName!= null) {
			return serv.findByUserStoryAssignedAndStatus(assignedName, status);
		}
		else if (ownerName != null && status!= null) {
			return serv.findByUserStoryOwnerAndStatus(ownerName, status);
		}
		else if (ownerName!=null) {
			return serv.findByUserStoryOwnerName(ownerName);
		}
		else if (assignedName != null) {
			return serv.findByUserStoryAssigneeName(assignedName);
		}
		else if (status!=null) {
			return serv.findByUserStoryStatus(status);
		}
		else {
			return null;
		}
	}

}
