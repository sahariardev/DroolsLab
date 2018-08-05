package com.ngfs.ruleengine.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.stereotype.Service;

import com.ngfs.ruleengine.model.Loan;

@Service
public class LoanService {

	public long calculateInterestRate() throws DroolsParserException, IOException
	{
		
		PackageBuilder packageBuilder = new PackageBuilder();
		String ruleFile = "/com/ngfs/rules/rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		
		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		
		Loan loan =new Loan();
		loan.setType("home");
		
		workingMemory.insert(loan);
		workingMemory.fireAllRules();
		
		return loan.getInterest();
	}
	public long calculateInterestRate(String loanType) throws DroolsParserException, IOException
	{
		
		PackageBuilder packageBuilder = new PackageBuilder();
		String ruleFile = "/com/ngfs/rules/rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		
		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		
		Loan loan =new Loan();
		loan.setType(loanType);
		
		workingMemory.insert(loan);
		workingMemory.fireAllRules();
		
		return loan.getInterest();
	}
}
