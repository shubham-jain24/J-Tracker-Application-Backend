package com.example.Tracker.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserStory")
public class UserStory {
	
	@Id
	private String userStoryId;
	private String epicId;
	private String userStoryTitle;
	private String userStoryDescription;
	private String userStoryAcceptanceCriteria;
	private String userStoryOwner;
	private String userStoryAssigned;
	private String userStoryStatus;
	private String userStoryStartDate;
	private String userStoryCompletionDate;
	private String userStoryExpectedCompletionDate;
	private int userStoryEffort;
	private int userStoryCompletedEffort;
	private int userStoryRemainingEffort;
	@DBRef
	private List<Comments> Comments = new ArrayList<>();
	
	public String getEpicId() {
		return epicId;
	}
	public String getUserStoryTitle() {
		return userStoryTitle;
	}
	public String getUserStoryDescription() {
		return userStoryDescription;
	}
	public String getUserStoryAcceptanceCriteria() {
		return userStoryAcceptanceCriteria;
	}
	public String getUserStoryOwner() {
		return userStoryOwner;
	}
	public String getUserStoryAssigned() {
		return userStoryAssigned;
	}
	public String getUserStoryStatus() {
		return userStoryStatus;
	}
	public String getUserStoryStartDate() {
		return userStoryStartDate;
	}
	public String getUserStoryCompletionDate() {
		return userStoryCompletionDate;
	}
	public String getUserStoryExpectedCompletionDate() {
		return userStoryExpectedCompletionDate;
	}
	public int getUserStoryEffort() {
		return userStoryEffort;
	}
	public int getUserStoryCompletedEffort() {
		return userStoryCompletedEffort;
	}
	public int getUserStoryRemainingEffort() {
		return userStoryRemainingEffort;
	}
	public void setEpicId(String epicId) {
		this.epicId = epicId;
	}
	public void setUserStoryTitle(String userStoryTitle) {
		this.userStoryTitle = userStoryTitle;
	}
	public void setUserStoryDescription(String userStoryDescription) {
		this.userStoryDescription = userStoryDescription;
	}
	public void setUserStoryAcceptanceCriteria(String userStoryAcceptanceCriteria) {
		this.userStoryAcceptanceCriteria = userStoryAcceptanceCriteria;
	}
	public void setUserStoryOwner(String userStoryOwner) {
		this.userStoryOwner = userStoryOwner;
	}
	public void setUserStoryAssigned(String userStoryAssigned) {
		this.userStoryAssigned = userStoryAssigned;
	}
	public void setUserStoryStatus(String userStoryStatus) {
		this.userStoryStatus = userStoryStatus;
	}
	public void setUserStoryStartDate(String userStoryStartDate) {
		this.userStoryStartDate = userStoryStartDate;
	}
	public void setUserStoryCompletionDate(String userStoryCompletionDate) {
		this.userStoryCompletionDate = userStoryCompletionDate;
	}
	public void setUserStoryExpectedCompletionDate(String userStoryExpectedCompletionDate) {
		this.userStoryExpectedCompletionDate = userStoryExpectedCompletionDate;
	}
	public void setUserStoryEffort(int userStoryEffort) {
		this.userStoryEffort = userStoryEffort;
	}
	public void setUserStoryCompletedEffort(int userStoryCompletedEffort) {
		this.userStoryCompletedEffort = userStoryCompletedEffort;
	}
	public void setUserStoryRemainingEffort(int userStoryRemainingEffort) {
		this.userStoryRemainingEffort = userStoryRemainingEffort;
	}
	public String getUserStoryId() {
		return userStoryId;
	}
	public List<Comments> getComments() {
		return Comments;
	}
	public void setUserStoryId(String userStoryId) {
		this.userStoryId = userStoryId;
	}
	public void setComments(List<Comments> comments) {
		Comments = comments;
	}
	
	
}
