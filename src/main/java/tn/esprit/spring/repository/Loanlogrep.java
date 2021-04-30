package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Loanlog;

@Repository
public interface Loanlogrep extends JpaRepository<Loanlog, Long> {
	
}
