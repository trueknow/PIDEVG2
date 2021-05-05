package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.ChatMessage;



public interface ChatMessageService {
	public List<ChatMessage> getAllChatMessage();
	public ChatMessage getbyidChatMessage(String id);
	public ChatMessage createChatMessage(ChatMessage m);
	public ChatMessage updateChatMessage(ChatMessage m);
	public void deleteChatMessage(String id);
	List<ChatMessage> retrieveAllChatMessages();
	ChatMessage retrieveChatMessage(String idcm);
	List<ChatMessage> retrieveAllChatMessage();
	public ChatMessage addChatMessage(ChatMessage c);

}
