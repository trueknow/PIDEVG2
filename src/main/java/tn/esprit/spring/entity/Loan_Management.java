package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
@Table( name = "loan_management")
public class Loan_Management implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long idrequest;
	
	@Column(name = "Amount_payed")
	private Double  AP;
	@Column(name = "Next_payment_amount")
	private Double NPA;
	@Column(name = "Next_payment_date")@Temporal (TemporalType.DATE)
	private Date NPD;
	@Enumerated(EnumType.STRING)
	private StateLoan state;
	
	

	@OneToOne
	private DAOUser DAOUser;
	
	public Loan_Management(Long idrequest ,Double AP , Double NPA,Date NPD)
	{ super();
	this.AP =AP;
	this.NPA = NPA;
	this. NPD =  NPD;}
	
	
	
	public void setidrequest(Long idrequest) {
		idrequest = idrequest;
	}
	
	public Double getAP() {
		return AP;
	}
	public void setAP(Double aP) {
		AP = aP;
	}
	public Double getNPA() {
		return NPA;
	}
	public void setNPA(Double nPA) {
		NPA = nPA;
	}
	public Date getNPD() {
		return NPD;
	}
	public void setNPD(Date nPD) {
		NPD = nPD;
	}



	public Long getIdrequest() {
		return idrequest;
	}



	public void setIdrequest(Long idrequest) {
		this.idrequest = idrequest;
	}



	public StateLoan getState() {
		return state;
	}



	public void setState(StateLoan state) {
		this.state = state;
	}



	public DAOUser getDAOUser() {
		return DAOUser;
	}



	public void setDAOUser(DAOUser DAOUser) {
		DAOUser = DAOUser;
	}
	
}
