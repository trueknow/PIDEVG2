package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Comment;


import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.CommentRepository;

@Service
public  class CommentServiceempl implements CommentService {

	@Autowired
	CommentRepository commentsRepository;
	private static final Logger L = LogManager.getLogger(CommentServiceempl.class);
	
	@Override
	public List<Comment> getComments() {
		List<Comment> comments = (List<Comment>) commentsRepository.findAll();
		for (Comment Comment : comments) {
			L.info("comments +++ : " + Comment );
		}
		return comments;
	}
	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> comments = (List<Comment>) commentsRepository.findAll();
		for (Comment Comment : comments) {
			L.info("comment +++ : " + Comment);
		}
		return comments;
	}
	@Override
	public Comment retrieveComment(String idcm) {
		L.info("in retrieveComment idcm = " + idcm);
		Comment c = commentsRepository.findById(Long.parseLong(idcm)).orElse(null);
		L.info("comment returned : " + c);
		return c;
	}
	@Override
	public Comment addComments(Comment c) {
		Comment CommentSaved = null;
		CommentSaved = commentsRepository.save(c);
		return CommentSaved;
	}

	@Override
	public void deleteComments(String idcm) {
		commentsRepository.deleteById(Long.parseLong(idcm));
		
	}

	@Override
	public Comment updateComments(Comment c) {
		Comment commentsAdded =  commentsRepository.save(c);
		return commentsAdded;
	}

}

