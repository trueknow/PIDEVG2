package tn.esprit.spring.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Loan_Management;

import tn.esprit.spring.repository.Loanmangrep;

@Service
public class Loan_Managementserviceimpl implements Loan_ManagementService{
	@Autowired
	Loanmangrep Loanmangrep ;
	private static final Logger L = LogManager.getLogger(Loan_Managementserviceimpl.class);

@Override
public Loan_Management get_Managementbyid(String id)
{
	L.info("in retrieveLoan idrequest = " + id);
	
	Loan_Management lm = Loanmangrep.findById(Long.parseLong(id)).orElse(null);
	
	L.info("Loan returned :" + lm);
	return lm ;

}
@Override
public Loan_Management addLoan_Management(Loan_Management LM){
	Loan_Management Loan_ManagementSaved = null ;
	Loan_ManagementSaved = Loanmangrep.save(LM);
	return Loan_ManagementSaved;
	

}
@Override
public Loan_Management UpdateLoan_Management(Loan_Management LM){

	return Loanmangrep.save(LM);
}

@Override
public void deleteLoan_Management(String id){
	
	Loanmangrep.deleteById(Long.parseLong(id));}
}


