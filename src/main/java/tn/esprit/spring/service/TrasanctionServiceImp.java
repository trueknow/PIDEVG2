package tn.esprit.spring.service;




import java.util.Date;


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
    public void payToAccount( String accountId, double amount) {

        // On charge le compte
		Account account = accountRepository.getOne(Long.parseLong(accountId));

        // on charge l'employe
        Deposit deposit = new Deposit();

        // mettre a jour date et montant compte et employe
        deposit.setDateTransaction( new Date() );
        deposit.setAmount( amount );
        deposit.setAccount( account );

        // sauvgarder l'operation
        transactionRepository.save(deposit);
        // mettre a jour le solde
        account.setSolde(account.getSolde() + amount);
		accountRepository.save(account);

    }
	
    @Override
    public void removeFromAccount(String accountId, double amount) {
		Account account = accountRepository.getOne(Long.parseLong(accountId));
        if ( account.getSolde() < amount )
            throw new RuntimeException( "Solde insuffisant !" );
        // on charge l'employe
        Withdrawal withdrawal = new Withdrawal(new Date(),amount, account);
        // mettre a jour date et montant compte et employe
        withdrawal.setDateTransaction( new Date() );
        withdrawal.setAmount( amount );
        withdrawal.setAccount( account );
        // sauvgarder l'operation
        transactionRepository.save(withdrawal);
        // mettre a jour le solde
        account.setSolde(account.getSolde() - amount);
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
    public Page<Transaction> getTransactions( String accountId, int page, int size ) {

		Pageable paging = PageRequest.of(page, size);
		return transactionRepository.getTransactions(accountId, paging);

    }
}


