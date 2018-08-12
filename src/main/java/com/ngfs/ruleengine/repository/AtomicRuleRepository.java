package com.ngfs.ruleengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngfs.ruleengine.model.AtomicRule;

public interface AtomicRuleRepository extends JpaRepository<AtomicRule, Long> {

	public AtomicRule findByRuleNumber(String number);
	public AtomicRule findByRuleName(String name);
}
