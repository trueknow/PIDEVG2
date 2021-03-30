package tn.esprit.spring.service;

import tn.esprit.spring.entity.Deposit;

public interface IDepositService {
	Deposit addDeposit(Deposit d);
  void deleteDeposit(String id);
	Deposit updateDeposit(Deposit d);

}
