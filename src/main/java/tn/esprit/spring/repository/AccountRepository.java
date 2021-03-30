package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Account;


public interface AccountRepository extends JpaRepository<Account, String> {
	
}