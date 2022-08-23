package com.example.exception;

public class ErrorMassage {

	private int errorcode;
	private String messages;
	public ErrorMassage(int errorcode, String messages) {
		super();
		this.errorcode = errorcode;
		this.messages = messages;
	}
	public ErrorMassage() {
		super();
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		return "ErrorMassage [errorcode=" + errorcode + ", messages=" + messages + "]";
	}
	
}
