package com.example.Tracker.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "IdSequence")
public class IdSequence {
	
	@Id
	private String idName;
	private int idValue;
	public String getIdName() {
		return idName;
	}
	public int getIdValue() {
		return idValue;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public void setIdValue(int idValue) {
		this.idValue = idValue;
	}
	
	
	

}

