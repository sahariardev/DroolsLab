package com.ngfs.ruleengine.requestmessage;

import java.util.ArrayList;
import java.util.List;

public class LoanRequestMessage {
	
	private List<String> messages;
	private boolean isAcceptable=true;
	public LoanRequestMessage()
	{
		messages=new ArrayList<>();
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public void addMessage(String message)
	{
		this.messages.add(message);
	}
	public boolean isAcceptable() {
		return isAcceptable;
	}
	public void setAcceptable(boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}
	@Override
	public String toString() {
		return "LoanRequestMessage [messages=" + messages + ", isAcceptable=" + isAcceptable + "]";
	}
	
	
	
	

}
