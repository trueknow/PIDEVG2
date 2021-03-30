package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Loan;

public interface Loanser {
	List<Loan> getLoan();
void saveLoan(Loan Loan);
	void addLoan(Loan Loan);
    void UpdateLoan(Loan Loan) ;
    void deleteLoan(String idrequest) ;
}