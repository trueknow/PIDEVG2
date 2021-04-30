package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.entity.DAOUser;

@Entity
public  class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private double solde;
	@OneToOne
	private DAOUser dAOUser;
	@OneToMany(mappedBy="account")
	private Collection<Transaction> transactions;
	
	public Account() {
		
	}

	public Account(Long accountId, Date dateCreation, DAOUser dAOUser, double solde, Collection<Transaction> transactions) {
		this.accountId = accountId;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.dAOUser = dAOUser;
		this.transactions = transactions;
	}
	public Account(Date dateCreation, DAOUser dAOUser, double solde, Collection<Transaction> transactions) {
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.dAOUser = dAOUser;
		this.transactions = transactions;
	}

	public Long getAccounIdt() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public DAOUser getUser() {
		return dAOUser;
	}

	public void setUser(DAOUser dAOUser) {
		this.dAOUser = dAOUser;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}


	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}


}

