package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Rating;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.RatingRepository;

@Service
public  class Ratingserviceempl implements Ratingservice {

	@Autowired
	RatingRepository RatingsRepository;
	private static final Logger L = LogManager.getLogger(Ratingserviceempl.class);
	
	@Override
	public List<Rating> getRatings() {
		List<Rating> Ratings = (List<Rating>) RatingsRepository.findAll();
		for (Rating Rating : Ratings) {
			L.info("Ratings +++ : " + Rating );
		}
		return Ratings;
	}

	@Override
	public Rating addRatings(Rating Ratings) {
		Rating RatingSaved = null;
		RatingSaved = RatingsRepository.save(Ratings);
		return RatingSaved;
	}

	@Override
	public void deleteRatings(Long idrating) {
		RatingsRepository.deleteById(idrating);
		
	}

	@Override
	public Rating updateRatings(Rating Ratings) {
		Rating RatingsAdded = (Rating) RatingsRepository.save(Ratings);
		return RatingsAdded;
	}

}

