package com.ngfs.ruleengine.helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import com.ngfs.ruleengine.model.ModelVariable;
import com.ngfs.ruleengine.model.Rule;

public class DroolsFileGenerator {
    
    private static List<Rule> rules;
    private static Set<String> models;
    
    public static Set<String> getModels() {
        return models;
    }

    public static void setModels(Set<String> models) {
        DroolsFileGenerator.models = models;
    }
    StringBuilder drlFile = new StringBuilder();

    public static List<Rule> getRules() {
        return rules;
    }

    public static void setRules(List<Rule> rules) {
        DroolsFileGenerator.rules = rules;
    }
    
    public File createDroolFile() {
    
        String fileString = droolFile();
        
        File file = new File("/home/sahariar/Codes/files/rule.drl");
        
        PrintWriter writer=null;
        try {
            writer = new PrintWriter(file);
            
            writer.print(fileString);
            writer.close();
        } catch (IOException ex) {
           // Logger.getLogger(DroolsFileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return file;
    }
    
    private String droolFile() {
        
        for(String model : models){
            writeImport(model);
        }
        drlFile.append(Keyword.IMPORT_MODELS).append("Result").
                append(Keyword.SEMICOLON).append(Keyword.NEW_LINE);
        drlFile.append(Keyword.NEW_LINE);
        
        drlFile.append("global Result result;");
        drlFile.append(Keyword.NEW_LINE);
        drlFile.append(Keyword.NEW_LINE);
        
        for(int ruleIdx = 0 ; ruleIdx < rules.size() ;  ruleIdx++) {
            
            writeRule(ruleIdx);
        }
        
        return drlFile.toString();
    }
    
    
    private void writeImport(String model){
        
        drlFile.append(Keyword.IMPORT_MODELS).append(model).
                append(Keyword.SEMICOLON).append(Keyword.NEW_LINE);
        
    }
    
    private void writeRule(int ruleIdx) {
        
        drlFile.append(Keyword.RULE).append(Keyword.SPACE).
                append(rules.get(ruleIdx).getRuleName()).
                append(Keyword.NEW_LINE);
        drlFile.append(Keyword.WHEN).append(Keyword.NEW_LINE);
        
        List<ModelVariable> modelVariableList = rules.get(ruleIdx).getModelvariables();
        
        for (int modelIdx = 0; modelIdx < modelVariableList.size() ; modelIdx++) {
            ModelVariable modelVariable = modelVariableList.get(modelIdx);
            writeModelVariable(modelVariable);
        }
        drlFile.append(Keyword.AND).append(Keyword.SPACE).
                append(Keyword.EVAL).append(Keyword.OPENING_Bracket);
        
        drlFile.append(rules.get(ruleIdx).getEvalCondition()).append(Keyword.CLOSING_Bracket).
                append(Keyword.NEW_LINE);
        
        drlFile.append(Keyword.THEN).append(Keyword.NEW_LINE);
        
        writeAction();
        
        drlFile.append(Keyword.NEW_LINE);
        drlFile.append(Keyword.END).append(Keyword.NEW_LINE).append(Keyword.NEW_LINE);
    } 

    private void writeModelVariable(ModelVariable modelVariable) {
     
        drlFile.append(modelVariable.getModelVariableName()).append(Keyword.COLON).
                append(Keyword.SPACE);
        drlFile.append(modelVariable.getModelName()).append(Keyword.OPENING_Bracket);
        drlFile.append(modelVariable.getGivenName()).append(Keyword.COLON).
                append(modelVariable.getVariableName());
        drlFile.append(Keyword.CLOSING_Bracket).append(Keyword.NEW_LINE);
    }

    private void writeAction() {
//        String x = "System.out.println( drools.getRule().getName() + \" got fired.\" )";
//        drlFile.append(x).append(Keyword.SEMICOLON).append(Keyword.NEW_LINE);
        String action1 = "result.setIsRuleHit(true)";
        drlFile.append(action1).append(Keyword.SEMICOLON).append(Keyword.NEW_LINE);
        String action2 = "result.setName(drools.getRule().getName())";
        drlFile.append(action2).append(Keyword.SEMICOLON);
    }
}
