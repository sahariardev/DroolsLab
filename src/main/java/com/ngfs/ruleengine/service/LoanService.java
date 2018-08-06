package com.ngfs.ruleengine.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngfs.ruleengine.model.Loan;
import com.ngfs.ruleengine.request.LoanRequestContainer;

@Service
public class LoanService {
	

	private final KieContainer kieContainer;

	@Autowired
	public LoanService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
     /*
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
	}*/
	
	public Loan calculateInterestRate(Loan loan)
	{
		System.out.println("hit");
		KieSession kieSession = kieContainer.newKieSession("testSession");
		

		kieSession.insert(loan);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println(loan);
		return loan;
	}
	public LoanRequestContainer checkLoanForm(LoanRequestContainer requestContainer)
	{
		System.out.println("hit");
		KieSession kieSession = kieContainer.newKieSession("loanSession");
		

		kieSession.insert(requestContainer);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println(requestContainer);
		return requestContainer;
	}
}
