package com.ngfs.ruleengine.model;

public class Loan {
	private long id;
	private String type;
	private long interest;
	private int age;
	private int amount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getInterest() {
		return interest;
	}
	public void setInterest(long interest) {
		this.interest = interest;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Loan [id=" + id + ", type=" + type + ", interest=" + interest + ", age=" + age + ", amount=" + amount
				+ "]";
	}

	
	
	

}
