package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Ratings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository  extends CrudRepository<Ratings, Long> {

}
