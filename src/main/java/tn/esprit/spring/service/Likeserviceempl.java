package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Like;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.LikeRepository;

@Service
public  class Likeserviceempl implements Likeservice {

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
	public Like addLikes(Like Likes) {
		Like LikeSaved = null;
		LikeSaved = LikesRepository.save(Likes);
		return LikeSaved;
	}

	@Override
	public void deleteLikes(Long idlike) {
		LikesRepository.deleteById(idlike);
		
	}

	@Override
	public Like updateLikes(Like Likes) {
		Like LikesAdded = (Like) LikesRepository.save(Likes);
		return LikesAdded;
	}

}

