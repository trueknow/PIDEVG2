package tn.esprit.spring.service;




import tn.esprit.spring.entity.Loan_Bank;
public interface Loan_BankService {
	public Loan_Bank addLoan_Bank(Loan_Bank LB) ;
	public Loan_Bank getbyidrequest(String idrequest);
	public void deleteLoan_Bank(String idrequest);
	public void calculamount(String idrequest ,double amount);//calcule le taux d'interet du pret 
	public void calculpayment(String idrequest ,double TATP,double PWI);// calcule le montant a payer avec interet chaque periode 

}
