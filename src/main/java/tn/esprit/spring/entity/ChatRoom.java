package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ChatRoom")
//@Document
public class ChatRoom {
    @Id@GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}