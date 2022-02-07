package com.example.Tracker.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ticket")
public class Ticket {
	
	@Id
	private String ticketId;
	
	private String ticketType;
	private String ticketTitle;
	private String ticketDescription;
	private String ticketOwner;
	private String ticketCreationDate;
	private String ticketTargetCompletionDate;
	private String ticketCompletionDate;
	
	@DBRef
	private List<Comments> Comments = new ArrayList<>();
	
	@DBRef
	private List<UserStory> userStories = new ArrayList<>();
	
	public String getTicketType() {
		return ticketType;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public String getTicketOwner() {
		return ticketOwner;
	}
	public String getTicketCreationDate() {
		return ticketCreationDate;
	}
	public String getTicketTargetCompletionDate() {
		return ticketTargetCompletionDate;
	}
	public String getTicketCompletionDate() {
		return ticketCompletionDate;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}
	public void setTicketCreationDate(String ticketCreationDate) {
		this.ticketCreationDate = ticketCreationDate;
	}
	public void setTicketTargetCompletionDate(String ticketTargetCompletionDate) {
		this.ticketTargetCompletionDate = ticketTargetCompletionDate;
	}
	public void setTicketCompletionDate(String ticketCompletionDate) {
		this.ticketCompletionDate = ticketCompletionDate;
	}
	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public List<Comments> getComments() {
		return Comments;
	}
	public void setComments(List<Comments> comments) {
		Comments = comments;
	}
	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	
	
}