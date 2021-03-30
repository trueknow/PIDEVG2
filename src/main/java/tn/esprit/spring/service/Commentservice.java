package tn.esprit.spring.service;
import tn.esprit.spring.entity.Comments;
import java.util.List;




public interface Commentservice {
	List<Comments> getComments();

	Comments  addComments(Comments Comments);
    void deleteComments(Long idcm) ;
    Comments updateComments(Comments Comments);

	
	
	
}
