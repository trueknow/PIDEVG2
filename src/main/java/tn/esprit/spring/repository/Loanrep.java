package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Loan;

@Repository

public interface Loanrep extends JpaRepository<Loan, String> {

}

