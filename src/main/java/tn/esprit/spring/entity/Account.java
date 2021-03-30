package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorColumn(name="TYPE_ACMPT")
public  abstract class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String accountId;
	private Date dateCreation;
	private double discount;
	private double overdraft;
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	@OneToMany(mappedBy="account")
	private Collection<Transaction> transactions;
	
	public Account() {
		
	}

	public Account(String accountId, Date dateCreation, double discount,double overdraft, Client client) {
		this.accountId = accountId;
		this.dateCreation = dateCreation;
		this.discount = discount;
		this.overdraft = overdraft;
		this.client = client;
	}

	public String getAccounIdt() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Client getClient() {
		return client;
	}

	public void setCleint(Client client) {
		this.client = client;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}


}
