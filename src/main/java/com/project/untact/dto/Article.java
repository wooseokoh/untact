package com.project.untact.dto;

public class Article {

	private int id;
	private String reDate;
	private String title;
	private String body;
	
	public Article(int id, String reDate, String title, String body) {
		this.id = id;
		this.reDate = reDate;
		this.title = title;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", reDate=" + reDate + ", title=" + title + ", body=" + body + "]";
	}
	

}
