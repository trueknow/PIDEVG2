package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Comment;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository  extends CrudRepository<Comment, Long> {
	@Query("SELECT c FROM Comment c WHERE c.idpost= :idpost")
	List<Comment> retrieveCommentsByPost(@Param("idpost") Long idpost);


}
