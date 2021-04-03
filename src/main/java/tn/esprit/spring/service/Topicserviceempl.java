package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Topic;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.TopicRepository;

@Service
public  class Topicserviceempl implements Topicservice {

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
	public Topic addTopic(Topic Topics) {
		Topic TopicSaved = null;
		TopicSaved = TopicRepository.save(Topics);
		return TopicSaved;
	}

	@Override
	public void deleteTopic(Long idTopic) {
		TopicRepository.deleteById(idTopic);
		
	}

	@Override
	public Topic updateTopic(Topic Topics) {
		Topic TopicAdded = (Topic) TopicRepository.save(Topics);
		return TopicAdded;
	}

}

