package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Deposit;
import tn.esprit.spring.repository.DepositRepository;

@Service
public class DepositServiceImp implements IDepositService {

	@Autowired
    DepositRepository depositRepository;
	
	@Override
	public Deposit addDeposit(Deposit d) {
		Deposit depositSaved = null;
		depositSaved = depositRepository.save(d);
		return depositSaved;
	}

	@Override
	public void deleteDeposit(String id) {
		depositRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Deposit updateDeposit(Deposit d) {
		Deposit depositAdded = depositRepository.save(d);
		return depositAdded;
	}

	
}

