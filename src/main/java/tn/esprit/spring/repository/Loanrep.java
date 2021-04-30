package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Loan;

@Repository
public interface Loanrep extends CrudRepository<Loan, Long> {
	
   
}

