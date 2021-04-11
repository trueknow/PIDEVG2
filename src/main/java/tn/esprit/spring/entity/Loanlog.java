package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name = "loan_log")
public class Loanlog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private Date Date;

	@Column(name = "Amount")
	private Double Amount;

	@Column(name = "Status", nullable = true)
	@Enumerated(EnumType.STRING)
	private Status Status;

	@ManyToOne
	User user;
	
	
	

	public Loanlog(java.util.Date date, Double amount, tn.esprit.spring.entity.Status status,
			tn.esprit.spring.entity.User user) {
		super();
		Date = date;
		Amount = amount;
		Status = status;
		this.user = user;
	}
	
	
	

	public Loanlog() {
		super();
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}

	
	
	

	

}
