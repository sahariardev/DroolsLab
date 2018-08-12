package com.ngfs.ruleengine.request;

public class RuleRequest {
	private String name;
    private String rule;
    private String ruleId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	@Override
	public String toString() {
		return "RuleRequest [name=" + name + ", rule=" + rule + ", ruleId=" + ruleId + "]";
	}
    
}
