package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import tn.esprit.spring.entity.User;

@Entity
@DiscriminatorColumn(name="TYPE_ACMPT")
public  abstract class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Date dateCreation;
	private double discount;
	private double overdraft;
	@OneToOne
	private User user;
	@OneToMany(mappedBy="account")
	private Collection<Transaction> transactions;
	
	public Account() {
		
	}

	public Account(Long accountId, Date dateCreation, double discount, double overdraft, User user) {
		this.accountId = accountId;
		this.dateCreation = dateCreation;
		this.discount = discount;
		this.overdraft = overdraft;
		this.user = user;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
