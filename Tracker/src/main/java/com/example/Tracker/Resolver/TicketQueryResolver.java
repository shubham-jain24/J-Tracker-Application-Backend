package com.example.Tracker.Resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Entity.Comments;
import com.example.Tracker.Entity.Ticket;
import com.example.Tracker.Entity.UserStory;
import com.example.Tracker.Service.CommentService;
import com.example.Tracker.Service.TicketService;
import com.example.Tracker.Service.UserStoryService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class TicketQueryResolver implements GraphQLQueryResolver{
	@Autowired
	CommentService commServ;
	@Autowired
	TicketService tickServ;
	@Autowired
	UserStoryService userServ;
	
	public List<Ticket> getTickets(){
		List<Ticket> Tickets = tickServ.findAllTicket();
		List<Ticket> UpdatedTicket = new ArrayList<>();
		for (Ticket ticket : Tickets) {
			List<Comments> commentsList = commServ.getAllCommennts(ticket.getTicketId());
			ticket.setComments(commentsList);
			List<UserStory> userStoryList = userServ.findUserStoryByEpicId(ticket.getTicketId());
			
			List<UserStory> updatedUserStory = new ArrayList<>();
			for (UserStory userStory : userStoryList) {
				List<Comments> usCommentList = commServ.getAllCommennts(userStory.getUserStoryId());
				userStory.setComments(usCommentList);
				updatedUserStory.add(userStory);
			}
			
			
			ticket.setUserStories(updatedUserStory);
			UpdatedTicket.add(ticket);
		}
		return UpdatedTicket;
	}
	
	public Optional<Ticket> getTicketById(String id) {
		Optional<Ticket> Ticket = tickServ.findTicketById(id);
		
		if (Ticket.isPresent()) {
			Ticket.get().setComments(commServ.getAllCommennts(Ticket.get().getTicketId()));
			List<UserStory> usObject = userServ.findUserStoryByEpicId(Ticket.get().getTicketId());
			List<UserStory> updatedUserStory = new ArrayList<>();
			for (UserStory userStory : usObject) {
				List<Comments> usCommentList = commServ.getAllCommennts(userStory.getUserStoryId());
				userStory.setComments(usCommentList);
				updatedUserStory.add(userStory);
			}
			Ticket.get().setUserStories(usObject);
		}
		
		return Ticket;
	}
	
}
