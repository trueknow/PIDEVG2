package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.ChatMessage;



public interface ChatMessageService {
	public List<ChatMessage> getAllUsers();
	public ChatMessage getbyidUser(String id);
	public ChatMessage createUser(ChatMessage m);
	public ChatMessage updateUser(ChatMessage m);
	public void deleteUser(String id);

}
