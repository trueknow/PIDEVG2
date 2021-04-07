package tn.esprit.spring.service;
import tn.esprit.spring.entity.Comment;
import java.util.List;




public interface CommentService {
	 List<Comment> getComments();
     Comment  addComments(Comment c);
    Comment updateComments(Comment c);
     List<Comment> retrieveAllComments();
     Comment retrieveComment(String idcm);
    void deleteComments(String idcm);

	
	
	
}
