package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Loan_Bank;

	@Repository
	public interface Loanbankrep extends CrudRepository<Loan_Bank, Long> {
		

}
