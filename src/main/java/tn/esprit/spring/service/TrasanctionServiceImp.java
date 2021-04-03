package tn.esprit.spring.service;


import java.util.Date;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Account;
import tn.esprit.spring.entity.Deposit;
import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.entity.Withdrawal;
import tn.esprit.spring.repository.AccountRepository;
import tn.esprit.spring.repository.TransactionRepository;


@Service
@Transactional
public class TrasanctionServiceImp implements ITransactionService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Account getAccountById(String accountId) {
		Optional<Account> account = accountRepository.findById(accountId);
		if (account == null)
			throw new RuntimeException("unfound account");

		return account.get();
	}
	
	@Override
	public void payToAccount(String accountId, double amount) {
		Account account = accountRepository.getOne(accountId);
		Deposit deposit = new Deposit(new Date(), amount, account);
		transactionRepository.save(deposit);
		account.setDiscount(account.getDiscount() + amount);
		accountRepository.save(account);

	}
	
	@Override
	public void removeFromAccount(String accountId, double amount) {
		Account account = accountRepository.getOne(accountId);
		double solde = 0;
		if (account.getDiscount() + solde < amount){
			throw new RuntimeException("Insufficient discount ");}
		Withdrawal withdrawal = new Withdrawal(new Date(),amount, account);
		transactionRepository.save(withdrawal);
		account.setDiscount(account.getDiscount() - amount);
		accountRepository.save(account);

	}


	@Override
	public void transfer(String accountOriginId, String accountDestId, double amount) {
		if (accountOriginId.equals(accountDestId)){
			throw new RuntimeException("Impossible operation: account id must be different");}
		removeFromAccount(accountOriginId, amount);
		payToAccount(accountDestId, amount);

	}
	
	@Override
	public Page<Transaction> getAccountTransactionByPage(String accountId,int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		return transactionRepository.getAccountTransactionsByPage(accountId, paging);
	}
}

