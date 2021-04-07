package tn.esprit.spring.entity;





import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "Offdate")
public class Offdate  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long congeID ;
	@Column(name="offdates")


    
    private String startTime  ;
    private String endTime  ;
    private int duration;
    private String status;
    private String pic;
    private String userId;
    private String validator;
    private String Sender;
    @ManyToOne
    User user;
	public Long getCongeID() {
		return congeID;
	}
	public void setCongeID(Long congeID) {
		this.congeID = congeID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getValidator() {
		return validator;
	}
	public void setValidator(String validator) {
		this.validator = validator;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
//	public Offdate() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Offdate(Long congeID, String startTime, String endTime, int duration, String status, String pic,
//			String userId, String validator, String sender) {
//		super();
//		this.congeID = congeID;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.duration = duration;
//		this.status = status;
//		this.pic = pic;
//		this.userId = userId;
//		this.validator = validator;
//		Sender = sender;
//	}
    
    }