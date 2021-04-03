package tn.esprit.spring.service;
import tn.esprit.spring.entity.Like;
import java.util.List;




public interface Likeservice {
	List<Like> getLikes();

	Like  addLikes(Like Likes);
    void deleteLikes(Long idlike) ;
    Like updateLikes(Like Likes);

	
	
	
}
