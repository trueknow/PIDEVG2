package tn.esprit.spring.service;
import tn.esprit.spring.entity.Topic;
import java.util.List;




public interface TopicService {
	List<Topic> getTopic();

	Topic  addTopic(Topic t);
    void deleteTopic(String idTopic) ;
    Topic updateTopic(Topic t);

	Topic retrieveTopic(String idTopic);

	List<Topic> retrieveAllTopics();

	
	
	
}
