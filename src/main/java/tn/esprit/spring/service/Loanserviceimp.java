package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.entity.Loanlog;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.entity.ProfileEnum;


import tn.esprit.spring.repository.Loanrep;
import tn.esprit.spring.repository.UserRepository;

@Service
public  class Loanserviceimp implements LoanService{

	@Autowired
	UserRepository UserRepository;
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
	public Loan getbyid(String idrequest)
	{
		L.info("in retrieveLoan idrequest = " + idrequest);
		
		Loan lo = Loanrep.findById(Long.parseLong(idrequest)).orElse(null);
		
		L.info("Loan returned :" + lo);
		return lo ;

	}
	@Override
	public Loan addLoan(Loan L,String id ){
		Loan LoanSaved = Loanrep.save(L) ;
		DAOUser u = UserRepository.findById(Long.parseLong(id)).orElse(null);
       System.out.println(u.getId());
		
       LoanSaved.setDAOUser(u);
      
		
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
	
	
//	@Override
//    public int Score(Boolean isFilesOk ,Loan Loan , DAOUser  DAOUser  , Loanlog Loanlog ) {
//		int Score = 0;
//	  
//    	if (DAOUser.getProfile()==ProfileEnum.ROLE_BANKER) Score=+20;
//    	//if (DAOUser.getAge()<60) Score=+20;// pas encore
//    	if (Loan.getIsFilesOk()==true) Score=+20;
//    	if (Loanlog.getStatus().equals("payed")) Score=+20;
//    	return Score;
//
//}
//
//
//	@Override
//	public int Score(Boolean isFilesOk, Loan Loan, DAOUser DAOUser, Loanlog Loan_log) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	}