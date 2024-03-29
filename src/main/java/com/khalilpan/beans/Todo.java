package com.khalilpan.beans;

import java.util.Date;

public class Todo {

	private int id;
	private String user;
	private String description;
	private Date targetDate;
	private boolean isDone;
	
	public Todo(int id, String user, String description, Date targetDate, boolean isDone) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}



	public Todo() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", description=" + description + ", targetDate=" + targetDate
				+ ", isDone=" + isDone + "]";
	}
	
	
	
	
}
