package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Comment;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.commentRepository;

@Service
public  class Commentserviceempl implements Commentservice {

	@Autowired
	commentRepository commentsRepository;
	private static final Logger L = LogManager.getLogger(Commentserviceempl.class);
	
	@Override
	public List<Comment> getComments() {
		List<Comment> comments = (List<Comment>) commentsRepository.findAll();
		for (Comment Comment : comments) {
			L.info("comments +++ : " + Comment );
		}
		return comments;
	}

	@Override
	public Comment addComments(Comment Comments) {
		Comment CommentSaved = null;
		CommentSaved = commentsRepository.save(Comments);
		return CommentSaved;
	}

	@Override
	public void deleteComments(Long idcm) {
		commentsRepository.deleteById(idcm);
		
	}

	@Override
	public Comment updateComments(Comment Comments) {
		Comment commentsAdded = (Comment) commentsRepository.save(Comments);
		return commentsAdded;
	}

}

