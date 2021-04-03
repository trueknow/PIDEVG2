package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository  extends CrudRepository<Comment, Long> {

}
