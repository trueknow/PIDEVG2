package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}