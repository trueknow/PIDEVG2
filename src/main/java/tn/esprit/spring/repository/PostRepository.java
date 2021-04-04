package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Post;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends CrudRepository<Post, Long> {
	@Query("SELECT p FROM Post p WHERE p.idTopic= :idTopic")
	List<Post> retrievePostsByTopic(@Param("idTopic") Long idTopic);


}
