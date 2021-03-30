package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository  extends CrudRepository<Likes, Long> {

}
