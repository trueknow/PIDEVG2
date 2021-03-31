package tn.esprit.spring.repository;

import tn.esprit.spring.entity.ChatMessage;
import tn.esprit.spring.entity.MessageStatus;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

  
}
