package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Long>{

}
