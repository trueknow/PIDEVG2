package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.Data;
import lombok.Getter;

import lombok.Setter;


@Data
@Entity


public class Presences implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long P_id ;
	
	
	private Date date;
	private Boolean present;
	private String activity;
	
	
	@OneToOne
	private User user;
	
	public Long getP_id() {
		return P_id;
	}
	public void setP_id(Long P_id) {
		this.P_id = P_id;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getPresent() {
		return present;
	}
	public void setPresent(Boolean present) {
		this.present = present;
	}
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	

	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Presences(Long p_id, Date date, Boolean present, String activity, User user) {
		super();
		P_id = p_id;
		this.date = date;
		this.present = present;
		this.activity = activity;
		
		this.user = user;
	}
	public Presences() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
	
	

}
