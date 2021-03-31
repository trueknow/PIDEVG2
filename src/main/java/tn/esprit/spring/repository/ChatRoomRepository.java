package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.ChatRoom;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long>{

}
