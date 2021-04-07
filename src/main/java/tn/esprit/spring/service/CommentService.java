package tn.esprit.spring.service;
import tn.esprit.spring.entity.Comment;
import java.util.List;




public interface CommentService {
	List<Comment> getComments();

	Comment  addComments(Comment Comments);
    void deleteComments(Long idcm) ;
    Comment updateComments(Comment Comments);

	
	
	
}
