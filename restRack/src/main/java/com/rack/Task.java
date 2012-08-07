package com.rack;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")
public class Task {
	private long taskID;
	private long userId;
	private String title;
	private String status;
	private Date dueDate;
	
	public long getTaskID() {
		return taskID;
	}
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", userId=" + userId + ", title="
				+ title + ", status=" + status + ", dueDate=" + dueDate + "]";
	}
	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


}
