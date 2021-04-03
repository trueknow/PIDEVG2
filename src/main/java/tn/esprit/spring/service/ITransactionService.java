package tn.esprit.spring.service;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Account;
import tn.esprit.spring.entity.Transaction;



public interface ITransactionService {

	public Account getAccountById(String accountId);

	void payToAccount(String accountId, double amount);

	public void removeFromAccount(String accountId, double amount);

    void transfer(String accountOriginId, String accountDestId, double amount);

	public Page<Transaction> getAccountTransactionByPage(String accountId, int page, int size);

}