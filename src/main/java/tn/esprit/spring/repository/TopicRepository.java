package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository  extends CrudRepository<Topic, Long> {

}
