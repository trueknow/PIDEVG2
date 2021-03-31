package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Chatmessage")
//@Document
public class ChatMessage implements Serializable{
   @Id@GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;
   private String chatId;
   private String senderId;
   private String recipientId;
   private String senderName;
   private String recipientName;
   private String content;
   private Date timestamp;
   private MessageStatus status;
   
   
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getChatId() {
	return chatId;
}
public void setChatId(String chatId) {
	this.chatId = chatId;
}
public String getSenderId() {
	return senderId;
}
public void setSenderId(String senderId) {
	this.senderId = senderId;
}
public String getRecipientId() {
	return recipientId;
}
public void setRecipientId(String recipientId) {
	this.recipientId = recipientId;
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
