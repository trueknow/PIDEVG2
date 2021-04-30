package tn.esprit.spring.entity;

import java.io.Serializable;



import javax.persistence.Table;


import javax.persistence.Entity;

import javax.persistence.Column;


import javax.persistence.Id;

import javax.persistence.OneToOne;
@Entity
@Table( name = "Loan_Bank")
public class Loan_Bank implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long idrequest;
	
	@Column(name = "Total_amount_topay")
	private Double TATP;
	@Column(name = "Payment_with_Interest")
	private Double PWI;
	
	@Column(name = "Payment_period")
	private String PP;
	
	@OneToOne(mappedBy="Loan_Bank")
	private Loan Loan;
	
	public Loan getLoan() {//??
		return Loan;
	}

	public void setLoan(Loan loan) {
		Loan = loan;
	}

	
	
	public Loan_Bank () {}; 
	public Loan_Bank(Long idrequest ,Double TATP , Double Interest,String PP)
	{ super();
	this.TATP =TATP;
	this.PWI=PWI;
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

	
	public Double getPWI() {
		return PWI;
	}
	public void setPWI(Double pWI) {
		PWI = pWI;
	}

	public String getPP() {
		return PP;
	}

	public void setPP(String pP) {
		PP = pP;
	}

}
