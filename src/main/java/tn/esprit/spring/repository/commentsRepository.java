package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentsRepository  extends CrudRepository<Comments, Long> {

}
