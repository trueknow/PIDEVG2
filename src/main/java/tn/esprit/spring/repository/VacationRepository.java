package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Offdate;

@Repository
public interface VacationRepository extends CrudRepository<Offdate, Long>{

	
}