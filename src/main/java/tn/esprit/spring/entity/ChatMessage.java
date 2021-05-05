package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Chatmessage")
public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ChatRoom")
	private ChatRoom chatId;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	
	
	private String senderName;
	private String recipientName;
	private String content;
	private Date timestamp;
	private MessageStatus status;

	public ChatMessage(Long id, ChatRoom chatId, User senderId,  String senderName, String recipientName,
			String content, Date timestamp, MessageStatus status) {
		super();
		this.id = id;
		this.chatId = chatId;
		this.user = senderId;
		
		this.senderName = senderName;
		this.recipientName = recipientName;
		this.content = content;
		this.timestamp = timestamp;
		this.status = status;
	}
public ChatMessage () {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChatRoom getChatId() {
		return chatId;
	}

	public void setChatId(ChatRoom chatId) {
		this.chatId = chatId;
	}

	public User getSenderId() {
		return user;
	}

	public void setSenderId(User senderId) {
		this.user = senderId;
	}





	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

}

