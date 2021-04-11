package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Loan_Bank;
public interface Loan_BankService {
	public Loan_Bank addLoan_Bank(Loan_Bank LB) ;
	public Loan_Bank getbyidrequest(String idrequest);
	public void deleteLoan_Bank(String idrequest);

}
