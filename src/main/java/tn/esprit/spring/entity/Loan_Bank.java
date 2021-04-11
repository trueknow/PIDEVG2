package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@Table( name = "Loan_Bank")
public class Loan_Bank implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long idrequest;
	
	@Column(name = "Total_amount_topay")
	private Double TATP;
	@Column(name = "amount_with_Interest")
	private Double Interest;
	@Column(name = "Payment_period")@Temporal (TemporalType.DATE)
	private Date PP;
	
	@OneToOne(mappedBy="Loan_Bank")
	private Loan Loan; 
	
	public Loan_Bank(Long idrequest ,Double TATP , Double Interest,Date PP)
	{ super();
	this.TATP =TATP;
	this.Interest = Interest;
	this. PP =  PP;}
	
	
	
	

	public Long getIdrequest() {
		return idrequest;
	}


	public void setIdrequest(Long idrequest) {
		this.idrequest = idrequest;
	}


	public Double getTATP() {
		return TATP;
	}


	public void setTATP(Double tATP) {
		TATP = tATP;
	}


	public Double getInterest() {
		return Interest;
	}


	public void setInterest(Double interest) {
		Interest = interest;
	}


	public Date getPP() {
		return PP;
	}


	public void setPP(Date pP) {
		PP = pP;
	}
	
}
