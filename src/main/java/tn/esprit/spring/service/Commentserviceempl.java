package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Comments;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.commentsRepository;

@Service
public  class Commentserviceempl implements Commentservice {

	@Autowired
	commentsRepository commentsRepository;
	private static final Logger L = LogManager.getLogger(Commentserviceempl.class);
	
	@Override
	public List<Comments> getComments() {
		List<Comments> comments = (List<Comments>) commentsRepository.findAll();
		for (Comments Comment : comments) {
			L.info("comments +++ : " + Comment );
		}
		return comments;
	}

	@Override
	public Comments addComments(Comments Comments) {
		Comments CommentSaved = null;
		CommentSaved = commentsRepository.save(Comments);
		return CommentSaved;
	}

	@Override
	public void deleteComments(Long idcm) {
		commentsRepository.deleteById(idcm);
		
	}

	@Override
	public Comments updateComments(Comments Comments) {
		Comments commentsAdded = (Comments) commentsRepository.save(Comments);
		return commentsAdded;
	}

}

