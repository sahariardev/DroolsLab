package com.ngfs.ruleengine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AtomicRule {
    
	@Id
	@GeneratedValue
    private long id;
    
    private String ruleNumber;
    private String ruleName;
    private String objectType;
    private String property;
    private String operator;
    private String compObjectType;
    private String compProperty;
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
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

    @Override
    public String toString() {
        return "AtomicRule{" + "ruleNumber=" + ruleNumber + ", ruleName=" + ruleName + ", objectType=" + objectType + ", property=" + property + ", operator=" + operator + ", compObjectType=" + compObjectType + ", compProperty=" + compProperty + '}';
    }
    
}