  package com.ngfs.ruleengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngfs.ruleengine.helper.CreateDrlFileBean;
import com.ngfs.ruleengine.helper.FireRuleBean;
import com.ngfs.ruleengine.model.Loan;
import com.ngfs.ruleengine.model.Result;
import com.ngfs.ruleengine.request.LoanRequest;
import com.ngfs.ruleengine.request.LoanRequestContainer;
import com.ngfs.ruleengine.requestmessage.LoanRequestMessage;
import com.ngfs.ruleengine.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;
	@Autowired
	CreateDrlFileBean createDrlFileBean;
	
	
	@GetMapping("/loan/{loanType}/interestrate")
	public String getInterestRate(@PathVariable ("loanType") String loanType )
	{
		Loan loan=new Loan();
		loan.setType(loanType);
		return "The interest rate is "+loanService.calculateInterestRate(loan).getInterest();
	
	}
	
	@PostMapping("/loan")
	public LoanRequestMessage checkFormRequest(@RequestBody LoanRequest request)
			
	{
		
		LoanRequest r=new LoanRequest();
		LoanRequestContainer requestContainer=new LoanRequestContainer();
		requestContainer.setRequest(request);
		requestContainer.setMessage(new LoanRequestMessage ());
		loanService.checkLoanForm(requestContainer);
		
		return requestContainer.getMessage();
	}
	
	@GetMapping("/create")
	public void Create()
	{
		createDrlFileBean.createInputFile();
		createDrlFileBean.createDRL();
	}
	
	@GetMapping("/isEligible/age/{age}/amount/{amount}")
	public Result varifyLoan(@PathVariable ("age") int age,@PathVariable ("amount") int amount)
	{
		
		Loan l=new Loan();
		l.setAge(age);
		l.setAmount(amount);
		FireRuleBean fireRuleBean=new FireRuleBean();
		return fireRuleBean.fireRules(l);		
	
	}
	
}
