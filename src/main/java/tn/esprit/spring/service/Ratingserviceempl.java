package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Ratings;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.RatingsRepository;

@Service
public  class Ratingserviceempl implements Ratingservice {

	@Autowired
	RatingsRepository RatingsRepository;
	private static final Logger L = LogManager.getLogger(Ratingserviceempl.class);
	
	@Override
	public List<Ratings> getRatings() {
		List<Ratings> Ratings = (List<Ratings>) RatingsRepository.findAll();
		for (Ratings Rating : Ratings) {
			L.info("Ratings +++ : " + Rating );
		}
		return Ratings;
	}

	@Override
	public Ratings addRatings(Ratings Ratings) {
		Ratings RatingSaved = null;
		RatingSaved = RatingsRepository.save(Ratings);
		return RatingSaved;
	}

	@Override
	public void deleteRatings(Long idrating) {
		RatingsRepository.deleteById(idrating);
		
	}

	@Override
	public Ratings updateRatings(Ratings Ratings) {
		Ratings RatingsAdded = (Ratings) RatingsRepository.save(Ratings);
		return RatingsAdded;
	}

}

