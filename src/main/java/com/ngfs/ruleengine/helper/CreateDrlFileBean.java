package com.ngfs.ruleengine.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngfs.ruleengine.model.AtomicRule;
import com.ngfs.ruleengine.model.ModelVariable;
import com.ngfs.ruleengine.model.Rule;
import com.ngfs.ruleengine.model.RuleEntry;
import com.ngfs.ruleengine.service.AtomicRuleService;
import com.ngfs.ruleengine.service.RuleService;

@Service
public class CreateDrlFileBean {
    
    @Autowired
    private RuleService ruleEntryBean;
    @Autowired
    private AtomicRuleService atomicRuleBean;
    
    
    private  List<Rule> rules = new ArrayList<>();
    private  Set<String> models = new HashSet<>();
    private  List<ModelVariable> modelVariableList = new ArrayList<>();
    private  long variableCounter = 1;
    
    
    //------creating input.txt file-------//
    
    public void createInputFile() {
        List<RuleEntry> ruleEntries = ruleEntryBean.getRuleEntries();
        File file = new File("/home/sahariar/Codes/files/inputFile.txt");
        StringBuilder inputFile = new StringBuilder();
        
        
        for(RuleEntry ruleEntry : ruleEntries) {
            String name = ruleEntry.getName();
            String rule = ruleEntry.getRule();
            
            inputFile.append("\"").append(name).append("\"").append("\n");
            inputFile = writeRule(rule , inputFile);
            
            inputFile.deleteCharAt(inputFile.length()-1);
            inputFile.append("\n");
        }
        
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(inputFile.toString());
            printWriter.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(CreateDrlFileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private StringBuilder writeRule(String rule, StringBuilder inputFile) {
        StringTokenizer st = new StringTokenizer(rule, " ");
        while (st.hasMoreTokens()) {  
            String token = st.nextToken();
            if(token.equals("(")){
                inputFile.append(token).append(" ");
            }
            else if(token.equals(")")){
                inputFile.append(token).append(" ");
            }
            else if(token.equals("&&") ){
                inputFile.append(token).append(" ");
            }
            else if(token.equals("||")){
                inputFile.append(token).append(" ");
            }
            else{
                AtomicRule atomicRule = atomicRuleBean.getAtomicRuleByRuleNumber(token);
                inputFile = writeAtomicRule(atomicRule , inputFile);
            }
        }
        return inputFile;
    }

    private StringBuilder writeAtomicRule(AtomicRule atomicRule, StringBuilder inputFile) {
        
        String objectType = atomicRule.getObjectType();
        String property = atomicRule.getProperty();
        String operator = atomicRule.getOperator();
        String compObjectType = atomicRule.getCompObjectType();
        String compProperty = atomicRule.getCompProperty();
        
        inputFile.append("[").append(objectType).append("]");
        inputFile.append(".").append(property).append(" ");
        
        inputFile.append(operator).append(" ");
        
        if(compObjectType.equals("noObject")){
            if(isNumeric(compProperty)){
                inputFile.append(compProperty).append(" ");
            }
            else {
                inputFile.append("\"").append(compProperty).append("\"").append(" ");
            }
            
        }
        else {
            inputFile.append("[").append(compObjectType).append("]");
             inputFile.append(".").append(property).append(" ");
        }
        return inputFile;
    }
    
    public static boolean isNumeric(String str) {
        
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    //------creating rule.drl file-------//
    
    public boolean createDRL() {
        File file = new File("/home/sahariar/Codes/files/inputFile.txt");
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNext()) {
                String ruleName = sc.nextLine();
                String condition = sc.nextLine();
                condition = makeTokens(condition);
                Rule rule = new Rule();
                rule.setRuleName(ruleName);
                rule.setEvalCondition(condition);
                rule.setModelvariables(modelVariableList);
                rules.add(rule);
                modelVariableList = new ArrayList<>();
            }
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(CreateDrlFileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DroolsFileGenerator drg = new DroolsFileGenerator();
        drg.setRules(rules);
        drg.setModels(models);
        File drlFile = drg.createDroolFile();
        return true;
    }
    
    private String makeTokens(String condition){
        
        String evalEqn = "";
        StringTokenizer tokens = new StringTokenizer(condition, " ");
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if(token.charAt(0) == '['){
                classVariableTokenparser(token);
                evalEqn += modelVariableList.get(modelVariableList.size()-1).getGivenName();
            }
            else {
                evalEqn += token;
            }
        }
        return evalEqn;
    }
    
    private void classVariableTokenparser(String token){
        
        int i=1;
        char now = token.charAt(i);
        String modelName = "";
        while(now != ']'){
            modelName += token.charAt(i);
            i++;
            now = token.charAt(i);
        }
        models.add(modelName);
        String variableName = "";
        for (int j = i+2 ; j < token.length() ; j++) {
            variableName += token.charAt(j);
        }
        
        ModelVariable mv = new ModelVariable();  
        
        mv.setModelVariableName(modelName.toLowerCase() + variableCounter);
        mv.setModelName(modelName);
        mv.setVariableName(variableName);
        mv.setGivenName("x" + variableCounter++);
        modelVariableList.add(mv);
        
    }
}   
