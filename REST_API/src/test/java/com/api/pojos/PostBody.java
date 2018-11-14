package com.api.pojos;

public class PostBody {

	String title;
	String content;
	String status;
	
	public PostBody() {
		
	}
	public PostBody(String title, String content, String status) {
		super();
		this.title = title;
		this.content = content;
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PostBody [title=" + title + ", content=" + content + ", status=" + status + "]";
	}
	
	
}
