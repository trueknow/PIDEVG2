package tn.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import tn.esprit.spring.entity.Loan_Bank;
import tn.esprit.spring.repository.Loanbankrep;

public class Loan_Bankserviceimpl implements Loan_BankService {
	@Autowired
	Loanbankrep Loanbankrep ;

	private static final Logger LB = LogManager.getLogger(Loan_Bankserviceimpl.class);
    @Override
	public Loan_Bank addLoan_Bank(Loan_Bank LB){
		Loan_Bank LoanSaved = null ;
		LoanSaved = Loanbankrep.save(LB);
		return LoanSaved;}
	
    @Override
	public Loan_Bank getbyidrequest(String idrequest)
	{
    	LB.info("in retrieveLoan idrequest = " + idrequest);
		
    	Loan_Bank lb = Loanbankrep.findById(Long.parseLong(idrequest)).orElse(null);
		
    	LB.info("Loan returned :" + lb);
		return lb ;}
    
    
    @Override
	public void deleteLoan_Bank(String idrequest){
		
    	Loanbankrep.deleteById(Long.parseLong(idrequest)) ;
    			}
}
