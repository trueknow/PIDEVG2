package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Rating;


import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.RatingRepository;

@Service
public  class Ratingserviceempl implements RatingService {

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
	public Rating addRatings(Rating r) {
		Rating RatingSaved = null;
		RatingSaved = RatingsRepository.save(r);
		return RatingSaved;
	}

	@Override
	public void deleteRatings(String idrating) {
		RatingsRepository.deleteById(Long.parseLong(idrating));
		
	}

	@Override
	public Rating updateRatings(Rating r) {
		Rating RatingsAdded = (Rating) RatingsRepository.save(r);
		return RatingsAdded;
	}
	@Override
	public Rating retrieveRating(String idrating) {
		L.info("in retrieverating idrating= " + idrating);
		Rating r = RatingsRepository.findById(Long.parseLong(idrating)).orElse(null);
		L.info("rating returned : " + r);
		return r;
	}
	@Override
	public List<Rating> retrieveAllRatings() {
		List<Rating> ratings = (List<Rating>) RatingsRepository.findAll();
		for (Rating rating : ratings) {
			L.info("rating +++ : " + rating);
		}
		return ratings;
	}

}

