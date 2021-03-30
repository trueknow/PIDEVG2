package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Withdrawal;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {

}
