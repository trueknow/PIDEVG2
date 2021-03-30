package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Deposit extends Transaction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Deposit() {
		super();
	}

	public Deposit(Date dateTransaction, double amount, Account account) {
		super(dateTransaction, amount, account);
	}

}

