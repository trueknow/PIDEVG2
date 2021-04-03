package tn.esprit.spring.service;
import tn.esprit.spring.entity.Topic;
import java.util.List;




public interface Topicservice {
	List<Topic> getTopic();

	Topic  addTopic(Topic Topic);
    void deleteTopic(Long idTopic) ;
    Topic updateTopic(Topic Topic);

	
	
	
}
