package tn.esprit.spring.service;


import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Loanlog;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.Loanlogrep;

  

@Service
public class Loan_logserviceimpl implements Loan_logService{


	Loanlogrep Loanlogrep  ;

	private static final Logger L = LogManager.getLogger(Loan_logserviceimpl.class);

	@Override
	public Loanlog getbyid(String id){
		L.info("in retrieveLoanlog id = " + id);
		
		Loanlog LG = Loanlogrep.findById(Long.parseLong( id)).orElse(null);
		
		L.info("Loanlog returned :" + LG);
		return LG ;

	}
	@Override
	public Loanlog addLoanlog(Loanlog LG){//by id user
		Loanlog LoanlogSaved = null ;
		LoanlogSaved = Loanlogrep.save(LG);
		return LoanlogSaved;
		
	
	}
	@Override
	public Loanlog UpdateLoanlog(Loanlog LG){//updateby id user

		return Loanlogrep.save(LG);
	}
}