package com.ngfs.ruleengine.model;

public class ModelVariable {
    
    private String modelVariableName;
    private String modelName;
    private String variableName;
    private String givenName;

    public String getModelVariableName() {
        return modelVariableName;
    }

    public void setModelVariableName(String modelVariableName) {
        this.modelVariableName = modelVariableName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public String toString() {
        return "ModelVariable{" + "modelVariableName=" + modelVariableName + ", modelName=" + modelName + ", variableName=" + variableName + ", givenName=" + givenName + '}';
    }
}