package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends CrudRepository<Like, Long> {

}
