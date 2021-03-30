package tn.esprit.spring.service;
import tn.esprit.spring.entity.Ratings;
import java.util.List;




public interface Ratingservice {
	List<Ratings> getRatings();

	Ratings  addRatings(Ratings Ratings);
    void deleteRatings(Long idrating) ;
    Ratings updateRatings(Ratings Ratings);

	
	
	
}
