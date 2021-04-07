package tn.esprit.spring.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity


public class Presences {
	@Id
	
	private int P_id;
	
	private Integer user_id;
	private String date;
	private Boolean present;
	private String activity;
	private int nb_present_monthly;
	
	@OneToOne
	private User user;
	
	public int getP_id() {
		return P_id;
	}
	public void setP_id() {
		this.P_id = P_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
//	public Presences() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Presences(int P_id, Integer user_id, String date, Boolean present, String obs, String activity) {
//		super();
//		this.P_id = P_id;
//		this.user_id = user_id;
//		this.date = date;
//		this.present = present;
//		this.nb_present_monthly=nb_present_monthly;
//		this.activity = activity;
//	}
	public int getNb_present_monthly() {
		return nb_present_monthly;
	}
	public void setNb_present_monthly(int nb_present_monthly) {
		this.nb_present_monthly = nb_present_monthly;
	}
	public void add(Presences presences) {
		// TODO Auto-generated method stub
		
	}
	public void remove(Presences presences) {
		// TODO Auto-generated method stub
		
	}
	
	

}
