package com.ngfs.ruleengine.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngfs.ruleengine.model.RuleEntry;
import com.ngfs.ruleengine.repository.RuleRepository;
import com.ngfs.ruleengine.request.RuleRequest;

@Service
public class RuleService {
	
	@Autowired
	RuleRepository  ruleRepository;
	
	public List<RuleEntry> getRuleEntries()
	{
		
		
		System.out.println("Here I am");
		List<RuleEntry> r=ruleRepository.findAll();
		System.out.println(r);
		
		return r;
	}
	public void createRuleEntry(RuleRequest ruleEntry){
        
        UUID uuid = UUID.randomUUID();
        String ruleId = uuid.toString();
        
        RuleEntry dRuleEntry = new RuleEntry();
        dRuleEntry.setName(ruleEntry.getName());
        dRuleEntry.setRule(ruleEntry.getRule());
        dRuleEntry.setRuleId(ruleId);
        ruleRepository.save(dRuleEntry);
        
    }

}
