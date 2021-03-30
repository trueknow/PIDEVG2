package tn.esprit.spring.service;
import tn.esprit.spring.entity.Likes;
import java.util.List;




public interface Likeservice {
	List<Likes> getLikes();

	Likes  addLikes(Likes Likes);
    void deleteLikes(Long idlike) ;
    Likes updateLikes(Likes Likes);

	
	
	
}
