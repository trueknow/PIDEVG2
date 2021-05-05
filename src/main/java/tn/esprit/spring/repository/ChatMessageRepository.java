package tn.esprit.spring.repository;

import tn.esprit.spring.entity.ChatMessage;

import tn.esprit.spring.entity.MessageStatus;





import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {


}

