package tn.esprit.spring.service;

import java.util.List;



import tn.esprit.spring.entity.Account;
public interface IAccountService {
	List<Account> retrieveAllAccounts();
	Account addAccount(Account a);
	void deleteAccount(String accountId);
	Account updateAccount(Account a);
	Account retrieveAccount(String accountId);
	long addOrUpdateAccount(Account a);
}


