package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.repository.Loanrep;

@Service()
public abstract class Loanservice implements Loanser {
	private List<Loan> Loan;
	
	@Autowired
	private Loanrep rep;

	@Override
	public List<Loan> getLoan() {
		return Loan;
	}

	@Override
    public void saveLoan(Loan Loan) {
		rep.save(Loan) ;
	}

	@Override
	public void addLoan(Loan Loan) {
		//rep.add(Loan);
	}

	//@SuppressWarnings("unchecked")
	//@Override
	//public void UpdateLoan(Loan Loan) {
	//	Loan.remove(Loan);
	//	((List<tn.esprit.spring.entity.Loan>) Loan).add(Loan);
	//}

	@Override
	public void deleteLoan(String idrequest) {

	}

}
