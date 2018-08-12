package com.ngfs.ruleengine.service;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ngfs.ruleengine.model.AtomicRule;
import com.ngfs.ruleengine.repository.AtomicRuleRepository;
import com.ngfs.ruleengine.request.AtomicRuleRequest;

@Service
public class AtomicRuleService {

	@Autowired
	AtomicRuleRepository atomicRuleRepository;

	public AtomicRule getAtomicRuleByRuleNumber(String ruleNumber) {
		return atomicRuleRepository.findByRuleNumber(ruleNumber);
	}

	public void create(AtomicRuleRequest[] atomicRules) {

		for (int i = 0; i < atomicRules.length; i++) {
			UUID uuid = UUID.randomUUID();
			String ruleNumber = uuid.toString();

			AtomicRule dAtomicRule = new AtomicRule();
			dAtomicRule.setObjectType(atomicRules[i].getObjectType());
			dAtomicRule.setRuleName(atomicRules[i].getRuleName());
			dAtomicRule.setProperty(atomicRules[i].getProperty());
			dAtomicRule.setOperator(atomicRules[i].getOperator());
			dAtomicRule.setCompObjectType(atomicRules[i].getCompObjectType());
			dAtomicRule.setCompProperty(atomicRules[i].getCompProperty());
			dAtomicRule.setRuleNumber(ruleNumber);

			atomicRuleRepository.save(dAtomicRule);

		}
	}

	public void create(AtomicRuleRequest atomicRule) {

		AtomicRule dAtomicRule = new AtomicRule();

		UUID uuid = UUID.randomUUID();
		String ruleNumber = uuid.toString();

		dAtomicRule.setObjectType(atomicRule.getObjectType());
		dAtomicRule.setRuleName(atomicRule.getRuleName());
		dAtomicRule.setProperty(atomicRule.getProperty());
		dAtomicRule.setOperator(atomicRule.getOperator());
		dAtomicRule.setCompObjectType(atomicRule.getCompObjectType());
		dAtomicRule.setCompProperty(atomicRule.getCompProperty());
		dAtomicRule.setRuleNumber(ruleNumber);

		atomicRuleRepository.save(dAtomicRule);
	}

	public List<AtomicRule> getAtomicRules() {

		return atomicRuleRepository.findAll();
	}

	public AtomicRule getAtomicRuleByRuleName(String ruleName) {

		return atomicRuleRepository.findByRuleName(ruleName);
	}

}
