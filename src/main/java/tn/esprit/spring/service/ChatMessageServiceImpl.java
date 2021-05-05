package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.ChatMessage;

import tn.esprit.spring.repository.ChatMessageRepository;
@Service
public class ChatMessageServiceImpl implements ChatMessageService{
	@Autowired
	ChatMessageRepository cm;
	
	private static final Logger L = LogManager.getLogger(ChatMessageServiceImpl.class);

	@Override
	public List<ChatMessage> getAllChatMessage() {
		List<ChatMessage> messages = (List<ChatMessage>) cm.findAll();
		for(ChatMessage message : messages)
			L.info("user +++ : " + message);

		return messages;
	}
	@Override
	public List<ChatMessage> retrieveAllChatMessage() {
		List<ChatMessage> chatmessages = (List<ChatMessage>) cm.findAll();
		for (ChatMessage chatmessage : chatmessages) {
			L.info("chatmessage +++ : " + chatmessage);
		}
		return chatmessages;
	}
	@Override
	public ChatMessage retrieveChatMessage(String idcm) {
		L.info("in retrieveChatMessage idcm = " + idcm);
		ChatMessage c = cm.findById(Long.parseLong(idcm)).orElse(null);
		L.info("chatmessage returned : " + c);
		return c;
	}

	@Override
	public ChatMessage getbyidChatMessage(String id) {
        L.info("in retrieve message id = " + id);
		
		ChatMessage m = cm.findById(Long.parseLong(id)).orElse(null);
		
		L.info("user returned :" + m);
		return m ;
	}

	
	@Override
	public ChatMessage addChatMessage(ChatMessage c) {
		ChatMessage ChatMessageSaved = null;
		ChatMessageSaved = cm.save(c);
		return ChatMessageSaved;
	}
	@Override

	public ChatMessage createChatMessage(ChatMessage m) {
		return cm.save(m);

	}

	@Override
	public ChatMessage updateChatMessage(ChatMessage m) {
		return cm.save(m);
	}

	@Override
	public void deleteChatMessage(String id) {
		cm.deleteById(Long.parseLong(id));
		
	}
	@Override
	public List<ChatMessage> retrieveAllChatMessages() {
		// TODO Auto-generated method stub
		return null;
	}

}
