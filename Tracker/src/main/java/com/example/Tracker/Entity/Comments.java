package com.example.Tracker.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comments {
	@Id
	private String commentId;
	private String sourceId;
	private String commentDescription;
	private String commentCreationDate;
	private String commentEditDate;
	
	public String getCommentDescription() {
		return commentDescription;
	}
	public String getCommentCreationDate() {
		return commentCreationDate;
	}
	public String getCommentEditDate() {
		return commentEditDate;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
	public void setCommentCreationDate(String commentCreationDate) {
		this.commentCreationDate = commentCreationDate;
	}
	public void setCommentEditDate(String commentEditDate) {
		this.commentEditDate = commentEditDate;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
}
