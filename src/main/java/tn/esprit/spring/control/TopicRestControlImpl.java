package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Topic;
import tn.esprit.spring.service.TopicService;

@RestController
public class TopicRestControlImpl {
	@Autowired
	TopicService topicService;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-topics
	@GetMapping("/retrieve-all-topics")
	@ResponseBody
	public List<Topic> getTopics() {
	List<Topic> list = topicService.retrieveAllTopics();
	return list;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-comment/{topic-id}
	@GetMapping("/retrieve-topic/{topic-id}")
	@ResponseBody
	 public Topic retrieveTopic(@PathVariable("topic-id") String topicId) {
	 return topicService.retrieveTopic(topicId);
	 }

	 // Ajouter Topic : http://localhost:8081/SpringMVC/servlet/add-topic
	@PostMapping("/add-topic")
	@ResponseBody
	public Topic addTopic(@RequestBody Topic t) {
		Topic topic = topicService.addTopic(t);
	 return topic;
	 }
	//http://localhost:8081/SpringMVC/servlet/remove-topic/{topic-id}
	@DeleteMapping("/remove-topic/{topic-id}")
	@ResponseBody
	public void removeComment(@PathVariable("topic-id") String topicId) {
		topicService.deleteTopic(topicId);
	 }

	// http://localhost:8081/SpringMVC/servlet/modify-topic
	@PutMapping("/modify-topic")
	@ResponseBody
	 public Topic modifyTopic(@RequestBody Topic topic) {
	 return topicService.updateTopic(topic);
	 }

}
