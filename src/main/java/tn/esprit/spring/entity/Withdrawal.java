package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Withdrawal() {
		super();
	}

	public Withdrawal(Date dateTransaction, double amount, Account account) {
		super(dateTransaction, amount, account);
	}

}
