package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Loan_Management;
@Repository
public interface Loanmangrep extends CrudRepository<Loan_Management, Long> {
		
	}



