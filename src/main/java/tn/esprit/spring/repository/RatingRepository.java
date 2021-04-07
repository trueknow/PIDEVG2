package tn.esprit.spring.repository;



import tn.esprit.spring.entity.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository  extends CrudRepository<Rating, Long> {
	@Query("SELECT r FROM Rating r WHERE r.post=:post")
	List<Rating> retrieveRatingsByPost(@Param("post") Long post);


}
