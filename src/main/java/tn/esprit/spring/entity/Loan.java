package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import antlr.collections.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "T_Loan")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Loan> loans = new ArrayList<>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idrequest;
	@Column
	private long iDCard;
	@Column
	private int amount;
	@Column
	@Enumerated(EnumType.STRING)
	private Payment_method payment_method;
	@Column
	private String description; // PDF
	@Column
	private String raison; // PDF
	@OneToOne
	private Loan_Bank Loan_Bank;

	public Loan(long idrequest, @NotBlank(message = "Display IDcard required ") long iDCard,
			@NotBlank(message = "verify the amount") @Size(min = 4) int amount,
			@NotBlank(message = "you must choose one of the options ") Payment_method payment_method, String description,
			String raison) {
		super();
		this.iDCard = iDCard;
		this.amount = amount;
		this.payment_method = payment_method;
		this.description = description;
		this.raison = raison;
		this.idrequest = idrequest;
	}
	
	

	public Loan() {
		super();
	}



	public long getIdrequest() {
		return idrequest;
	}

	public void setIdrequest(long idrequest) {
		this.idrequest = idrequest;
	}

	public long getiDCard() {
		return iDCard;
	}

	public void setiDCard(long iDCard) {
		this.iDCard = iDCard;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public Payment_method getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(Payment_method payment_method) {
		this.payment_method = payment_method;
	}

	public Loan_Bank getLoan_Bank() {
		return Loan_Bank;
	}

	public void setLoan_Bank(Loan_Bank loan_Bank) {
		Loan_Bank = loan_Bank;
	}
	
	
	
	
	

}
