package tn.esprit.spring.service;
import tn.esprit.spring.entity.Like;
import java.util.List;




public interface LikeService {
 List<Like> getLikes();
 Like  addLikes(Like L);
 void deleteLikes(String idlike) ;
 Like updateLikes(Like L);
 List<Like> retrieveAllLikes();
 Like retrieveLike(String idlike);



	
	
	
}
