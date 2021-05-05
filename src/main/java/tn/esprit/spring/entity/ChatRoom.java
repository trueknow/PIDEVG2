package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@Table(name = "ChatRoom")

public class ChatRoom implements Serializable{
	
	public ChatRoom() {
		super();
	}
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (cascade = CascadeType.ALL, mappedBy ="chatId" )
    private Set<ChatMessage> ChatMessage;
    
    @ManyToOne
    
	@JoinColumn(name = "USER_ID")
	private User senderId;
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User recipientId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<ChatMessage> getChatMessage() {
		return ChatMessage;
	}
	public void setChatMessage(Set<ChatMessage> chatMessage) {
		ChatMessage = chatMessage;
	}
	public User getSenderId() {
		return senderId;
	}
	public void setSenderId(User senderId) {
		this.senderId = senderId;
	}
	public User getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(User recipientId) {
		this.recipientId = recipientId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ChatRoom(Long id, Set<tn.esprit.spring.entity.ChatMessage> chatMessage, User senderId, User recipientId) {
		super();
		this.id = id;
		ChatMessage = chatMessage;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}
	
    
}
