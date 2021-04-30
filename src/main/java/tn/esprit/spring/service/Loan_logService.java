package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Loanlog;

public interface Loan_logService {
	
	public Loanlog getbyid(String id);
	public Loanlog addLoanlog(Loanlog LG) ;
    public Loanlog UpdateLoanlog(Loanlog LG) ;


	
}
