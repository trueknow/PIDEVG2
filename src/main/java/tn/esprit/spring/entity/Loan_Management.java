package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
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
	
	@OneToOne(mappedBy="Loan_Management")
	private User User;
	
	
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
	
}
