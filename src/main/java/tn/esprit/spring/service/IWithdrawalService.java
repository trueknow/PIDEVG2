package tn.esprit.spring.service;


import tn.esprit.spring.entity.Withdrawal;

public interface IWithdrawalService {
	Withdrawal addWithdrawal(Withdrawal w);
  void deleteWithdrawal(String id);
	Withdrawal updateWithdrawal(Withdrawal w);

}
