package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Like;


import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.LikeRepository;

@Service
public  class Likeserviceempl implements LikeService {

	@Autowired
	LikeRepository LikesRepository;
	private static final Logger L = LogManager.getLogger(Likeserviceempl.class);
	
	@Override
	public List<Like> getLikes() {
		List<Like> Likes = (List<Like>) LikesRepository.findAll();
		for (Like Like : Likes) {
			L.info("Likes +++ : " + Like );
		}
		return Likes;
	}

	@Override
	public Like addLikes(Like l) {
		Like LikeSaved = null;
		LikeSaved = LikesRepository.save(l);
		return LikeSaved;
	}

	@Override
	public void deleteLikes(String idlike) {
		LikesRepository.deleteById(Long.parseLong(idlike));
		
	}

	@Override
	public Like updateLikes(Like L) {
		Like LikesAdded = LikesRepository.save(L);
		return LikesAdded;
	}
	@Override
	public Like retrieveLike (String idlike) {
		L.info("in retrieveLike idlike = " + idlike);
		Like l = LikesRepository.findById(Long.parseLong(idlike)).orElse(null);
		L.info("like returned : " + l);
		return l;
	}
	@Override
	public List<Like> retrieveAllLikes() {
		List<Like> likes = (List<Like>) LikesRepository.findAll();
		for (Like like : likes) {
			L.info("like +++ : " + like);
		}
		return likes;
	}
	

}

