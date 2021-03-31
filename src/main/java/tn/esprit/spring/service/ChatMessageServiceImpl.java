package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import tn.esprit.spring.entity.ChatMessage;
import tn.esprit.spring.repository.ChatMessageRepository;

public class ChatMessageServiceImpl implements ChatMessageService{
	
	ChatMessageRepository cm;
	
	private static final Logger L = LogManager.getLogger(ChatMessageServiceImpl.class);

	@Override
	public List<ChatMessage> getAllUsers() {
		List<ChatMessage> messages = (List<ChatMessage>) cm.findAll();
		for(ChatMessage message : messages)
			L.info("user +++ : " + message);

		return messages;
	}

	@Override
	public ChatMessage getbyidUser(String id) {
        L.info("in retrieve message id = " + id);
		
		ChatMessage m = cm.findById(Long.parseLong(id)).orElse(null);
		
		L.info("user returned :" + m);
		return m ;
	}

	@Override
	public ChatMessage createUser(ChatMessage m) {
		return cm.save(m);

	}

	@Override
	public ChatMessage updateUser(ChatMessage m) {
		return cm.save(m);
	}

	@Override
	public void deleteUser(String id) {
		cm.deleteById(Long.parseLong(id));
		
	}

}
