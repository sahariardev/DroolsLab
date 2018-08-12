package com.ngfs.ruleengine.model;

public class Result {
    private boolean isRuleHit;
    private String name;

    public boolean getIsRuleHit() {
        return isRuleHit;
    }

    public void setIsRuleHit(boolean isRuleHit) {
        this.isRuleHit = isRuleHit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}