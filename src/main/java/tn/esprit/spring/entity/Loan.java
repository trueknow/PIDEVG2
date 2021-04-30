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
@Table(name = "Loan")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Loan> loans = new ArrayList<>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idrequest;
	
	@Column
	private Double amount;
	@Column
	@Enumerated(EnumType.STRING)
	private Payment_method payment_method;
	@Column
	private String Files; // uplooad multiple files //les fichiers pdf de garantie et raison  
	@Column
	private Boolean isFilesOk;//l employee met true or false pour les fichier ca sert a la calcul du scoring
	
	@OneToOne
	private User user;
	@OneToOne
	private Loan_Bank Loan_Bank;
	
	public Loan() {
		super();//?
	}

	public Loan(long idrequest,
			@NotBlank(message = "verify the amount") @Size(min = 4) Double amount,
			@NotBlank(message = "you must choose one of the options ") Payment_method payment_method, String Files,Boolean isFilesOk) 
	{
		super();//?
		
		this.amount = amount;
		this.payment_method = payment_method;
		this.Files=Files;
		this.idrequest = idrequest;
		this.isFilesOk=isFilesOk;
	}
	
	

	

	public long getIdrequest() {
		return idrequest;
	}

	public void setIdrequest(long idrequest) {
		this.idrequest = idrequest;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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



	public User getUser() {
		return user;
	}



	public void setUser(User User) {
		user = User;
	}



	public String getFiles() {
		return Files;
	}



	public void setFiles(String files) {
		Files = files;
	}



	public Boolean getIsFilesOk() {
		return isFilesOk;
	}



	public void setIsFilesOk(Boolean isFilesOk) {
		this.isFilesOk = isFilesOk;
	}
	
	
	
	
	

}
