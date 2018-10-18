package com.augenblick.lunchbox.account.rest;

public class RestResponse {
	
	private String[] messages;
	
	public RestResponse(String[] messages) {
		this.messages = messages;
	}

	public String[] getMessages() {
		return messages;
	}
	
	public void setMessages(String[] messages) {
		this.messages = messages;
	}
}
