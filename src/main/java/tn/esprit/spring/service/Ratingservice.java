package tn.esprit.spring.service;
import tn.esprit.spring.entity.Rating;
import java.util.List;




public interface Ratingservice {
	List<Rating> getRatings();

	Rating  addRatings(Rating Ratings);
    void deleteRatings(Long idrating) ;
    Rating updateRatings(Rating Ratings);

	
	
	
}
