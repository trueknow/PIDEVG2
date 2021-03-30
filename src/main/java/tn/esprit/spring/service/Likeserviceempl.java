package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Likes;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.LikesRepository;

@Service
public  class Likeserviceempl implements Likeservice {

	@Autowired
	LikesRepository LikesRepository;
	private static final Logger L = LogManager.getLogger(Likeserviceempl.class);
	
	@Override
	public List<Likes> getLikes() {
		List<Likes> Likes = (List<Likes>) LikesRepository.findAll();
		for (Likes Like : Likes) {
			L.info("Likes +++ : " + Like );
		}
		return Likes;
	}

	@Override
	public Likes addLikes(Likes Likes) {
		Likes LikeSaved = null;
		LikeSaved = LikesRepository.save(Likes);
		return LikeSaved;
	}

	@Override
	public void deleteLikes(Long idlike) {
		LikesRepository.deleteById(idlike);
		
	}

	@Override
	public Likes updateLikes(Likes Likes) {
		Likes LikesAdded = (Likes) LikesRepository.save(Likes);
		return LikesAdded;
	}

}

