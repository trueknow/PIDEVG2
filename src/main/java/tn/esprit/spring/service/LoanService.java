package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Loan;

public interface LoanService {

	public List<Loan> getALLLoan();
	public Loan getbyidrequest(String idrequest);
	public Loan addLoan(Loan L) ;
    public Loan UpdateLoan(Loan L) ;
	public void deleteLoan(String idrequest);

  
    
		
	
   
		
	}
   

	