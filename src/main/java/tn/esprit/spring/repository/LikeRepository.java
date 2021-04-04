package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Like;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface LikeRepository  extends CrudRepository<Like, Long> {
	@Query("SELECT l FROM Like l WHERE l.idpost= :idpost")
	List<Like> retrieveLikesByPost(@Param("idpost") Long idpost);


}
