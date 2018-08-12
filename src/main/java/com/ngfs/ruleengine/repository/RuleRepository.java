package com.ngfs.ruleengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngfs.ruleengine.model.RuleEntry;

public interface RuleRepository extends JpaRepository<RuleEntry, Long> {

}
