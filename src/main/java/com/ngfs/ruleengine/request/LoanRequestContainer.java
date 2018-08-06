package com.ngfs.ruleengine.request;

import com.ngfs.ruleengine.requestmessage.LoanRequestMessage;

public class LoanRequestContainer {

	private LoanRequest request;
	private LoanRequestMessage message;
	public LoanRequest getRequest() {
		return request;
	}
	public void setRequest(LoanRequest request) {
		this.request = request;
	}
	public LoanRequestMessage getMessage() {
		return message;
	}
	public void setMessage(LoanRequestMessage message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "LoanRequestContainer [request=" + request + ", message=" + message + "]";
	}
	
	
}
