package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Account;

import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	AccountRepository accountRepository;
	private static final Logger L = LogManager.getLogger(AccountServiceImpl.class);
	
	@Override
	public List<Account> retrieveAllAccounts() {
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		for (Account account : accounts) {
			L.info("account +++ : " + account);
		}
		return accounts;
	}

	@Override
	public Account addAccount(Account a) {
		Account accountSaved = null;
		accountSaved = accountRepository.save(a);
		return accountSaved;
	}

	@Override
	public void deleteAccount(String accountId) {
		accountRepository.deleteById(Long.parseLong(accountId));
		
	}

	@Override
	public Account updateAccount(Account a) {
		Account accountAdded = accountRepository.save(a);
		return accountAdded;
	}

	@Override
	public Account retrieveAccount(String accountId) {
		L.info("in retrieveUser accountId= " + accountId);
		Account a = accountRepository.findById(Long.parseLong(accountId)).orElse(null);
		L.info("account returned : " + a);
		return a;
	}

}
