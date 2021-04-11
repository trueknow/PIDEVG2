package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Loan;

import tn.esprit.spring.repository.Loanrep;

@Service
public  class Loanserviceimp implements LoanService{


	@Autowired
	Loanrep Loanrep ;

	private static final Logger L = LogManager.getLogger(Loanserviceimp.class);

	@Override
	public List<Loan> getALLLoan(){

		List<Loan> loans = (List<Loan>) Loanrep.findAll();
		for(Loan loan : loans)
			L.info("loan +++ : " + loan);

		return loans;

	}

	
	@Override
	public Loan getbyidrequest(String idrequest)
	{
		L.info("in retrieveLoan idrequest = " + idrequest);
		
		Loan lo = Loanrep.findById(Long.parseLong(idrequest)).orElse(null);
		
		L.info("Loan returned :" + lo);
		return lo ;

	}
	@Override
	public Loan addLoan(Loan L){
		Loan LoanSaved = null ;
		LoanSaved = Loanrep.save(L);
		return LoanSaved;
		
	
	}
	@Override
	public Loan UpdateLoan(Loan L){

		return Loanrep.save(L);
	}
	
	@Override
	public void deleteLoan(String idrequest){
		
		Loanrep.deleteById(Long.parseLong(idrequest));
	}

}