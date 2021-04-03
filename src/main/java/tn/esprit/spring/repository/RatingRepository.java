package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository  extends CrudRepository<Rating, Long> {

}
