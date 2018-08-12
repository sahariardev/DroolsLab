package com.ngfs.ruleengine.request;

public class AtomicRuleRequest {

	
	private String ruleNumber;
    private String ruleName;
    private String objectType;
    private String property;
    private String operator;
    private String compObjectType;
    private String compProperty;
	public String getRuleNumber() {
		return ruleNumber;
	}
	public void setRuleNumber(String ruleNumber) {
		this.ruleNumber = ruleNumber;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCompObjectType() {
		return compObjectType;
	}
	public void setCompObjectType(String compObjectType) {
		this.compObjectType = compObjectType;
	}
	public String getCompProperty() {
		return compProperty;
	}
	public void setCompProperty(String compProperty) {
		this.compProperty = compProperty;
	}
    
}
