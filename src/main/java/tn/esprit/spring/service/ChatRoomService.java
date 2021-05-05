package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.ChatRoom;


public interface ChatRoomService {
	public List<ChatRoom> getAllUsers();
	public ChatRoom getbyidUser(String id);
	public ChatRoom createUser(ChatRoom m);
	public ChatRoom updateUser(ChatRoom m);
	public void deleteUser(String id);
	ChatRoom addChatRoom(ChatRoom c);

}
