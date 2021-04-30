package tn.esprit.spring.service;
import java.util.List;


import tn.esprit.spring.entity.Loan_Management;


public interface Loan_ManagementService {
	public Loan_Management get_Managementbyid(String id);
	public Loan_Management addLoan_Management(Loan_Management LM) ;
    public Loan_Management UpdateLoan_Management(Loan_Management LM) ;
	public void deleteLoan_Management(String id);
	public void alert(long id);
	


}
