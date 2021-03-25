package com.luv2code.springdemo.response;

import com.mysql.jdbc.log.Log;

public class CustomerErrorResponse {
	
	private int status;
	private String message;
	private long timestamp;
	
	public CustomerErrorResponse(){
		
	}
	
	public CustomerErrorResponse(int status, String messageString, long timestamp) {
		this.status = status;
		this.message = messageString;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessageString() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
