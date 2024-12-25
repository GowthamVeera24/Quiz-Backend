package com.Quiz_server.Dto;

import java.util.List;

import com.Quiz_server.entity.Question;

public class TestDto {

	private long id;
	
	private String title;
	
	private String description;
	
	private long time;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	
	
}
