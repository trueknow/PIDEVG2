package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entity.ChatMessage;
import tn.esprit.spring.entity.ChatRoom;
import tn.esprit.spring.repository.ChatRoomRepository;

public class ChatRoomServiceImpl implements ChatRoomService{

    ChatRoomRepository cr;
	
	private static final Logger L = LogManager.getLogger(ChatRoomServiceImpl.class);
	@Override
	public List<ChatRoom> getAllUsers() {
		List<ChatRoom> messages = (List<ChatRoom>) cr.findAll();
		for(ChatRoom message : messages)
			L.info("user +++ : " + message);

		return messages;
	}

	@Override
	public ChatRoom getbyidUser(String id) {
        L.info("in retrieve message id = " + id);
		
		ChatRoom m = cr.findById(Long.parseLong(id)).orElse(null);
		
		L.info("user returned :" + m);
		return m ;
	}

	@Override
	public ChatRoom createUser(ChatRoom m) {
		return cr.save(m);
	}

	@Override
	public ChatRoom updateUser(ChatRoom m) {
		return cr.save(m);
	}

	@Override
	public void deleteUser(String id) {
		cr.deleteById(Long.parseLong(id));
		
	}

}
