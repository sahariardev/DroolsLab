package com.ngfs.ruleengine.controller;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ngfs.ruleengine.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;
	@GetMapping("/loan/{loanType}/interestrate")
	public String getInterestRate(@PathVariable ("loanType") String loanType )
	{
		try {
			return "The interest rate is "+loanService.calculateInterestRate(loanType);
		} catch (DroolsParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}