package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends CrudRepository<Posts, Long> {

}
