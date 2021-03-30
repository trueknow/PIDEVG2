package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Withdrawal;
import tn.esprit.spring.repository.WithdrawalRepository;

@Service
public class WithdrawalServiceImp implements IWithdrawalService {

	@Autowired
    WithdrawalRepository withdrawalRepository;
	
	@Override
	public Withdrawal addWithdrawal(Withdrawal w) {
		Withdrawal withdrawalSaved = null;
		withdrawalSaved = withdrawalRepository.save(w);
		return withdrawalSaved;
	}

	@Override
	public void deleteWithdrawal(String id) {
		withdrawalRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Withdrawal updateWithdrawal(Withdrawal w) {
		Withdrawal withdrawalAdded = withdrawalRepository.save(w);
		return withdrawalAdded;
	}

	
}
