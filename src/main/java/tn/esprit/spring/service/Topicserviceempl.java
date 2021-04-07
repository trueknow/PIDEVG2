package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Topic;

import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.TopicRepository;

@Service
public  class Topicserviceempl implements TopicService {

	@Autowired
	TopicRepository TopicRepository;
	private static final Logger L = LogManager.getLogger(Topicserviceempl.class);
	
	@Override
	public List<Topic> getTopic() {
		List<Topic> Topics = (List<Topic>) TopicRepository.findAll();
		for (Topic Topic : Topics) {
			L.info("Topics +++ : " + Topic );
		}
		return Topics;
	}

	@Override
	public Topic addTopic(Topic t) {
		Topic TopicSaved = null;
		TopicSaved = TopicRepository.save(t);
		return TopicSaved;
	}

	@Override
	public void deleteTopic(String idTopic) {
		TopicRepository.deleteById(Long.parseLong(idTopic));
		
	}

	@Override
	public Topic updateTopic(Topic t) {
		Topic TopicAdded = TopicRepository.save(t);
		return TopicAdded;
	}
	@Override
	public Topic retrieveTopic(String idTopic) {
		L.info("in retrieveTopic idTopic= " + idTopic);
		Topic t = TopicRepository.findById(Long.parseLong(idTopic)).orElse(null);
		L.info("topic returned : " + t);
		return t;
	}
	@Override
	public List<Topic> retrieveAllTopics() {
		List<Topic> topics = (List<Topic>) TopicRepository.findAll();
		for (Topic topic : topics) {
			L.info("topic +++ : " + topic);
		}
		return topics;
	}


}

