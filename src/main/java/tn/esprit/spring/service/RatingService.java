package tn.esprit.spring.service;
import tn.esprit.spring.entity.Rating;
import java.util.List;




public interface RatingService {
	List<Rating> getRatings();

	Rating  addRatings(Rating r);
    void deleteRatings(String idrating) ;
    Rating updateRatings(Rating r);
    Rating retrieveRating(String idrating);

	List<Rating> retrieveAllRatings();
    
		
	}

	
	
	

