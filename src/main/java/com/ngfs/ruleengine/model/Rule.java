package com.ngfs.ruleengine.model;

import java.util.List;

public class Rule {
    private String ruleName;
    private List<ModelVariable> modelvariables ;
    private String evalCondition;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public List<ModelVariable> getModelvariables() {
        return modelvariables;
    }

    public void setModelvariables(List<ModelVariable> modelvariables) {
        this.modelvariables = modelvariables;
    }

    public String getEvalCondition() {
        return evalCondition;
    }

    public void setEvalCondition(String evalCondition) {
        this.evalCondition = evalCondition;
    }

    @Override
    public String toString() {
        return "Rule{" + "ruleName=" + ruleName + ", modelvariables=" + modelvariables + ", evalCondition=" + evalCondition + '}';
    }
    
}