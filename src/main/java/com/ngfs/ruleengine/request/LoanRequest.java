package com.ngfs.ruleengine.request;

public class LoanRequest {

	
	private String applicant;
	private String type;
	private int age;
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "LoanRequest [applicant=" + applicant + ", type=" + type + ", age=" + age + "]";
	}
	
	
	
	
}
