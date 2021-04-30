package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Loanlog;
public interface LoanService {

	public List<Loan> getALLLoan();
	public Loan getbyid(String id);//
	public Loan addLoan( Loan L,String id ) ;
    public Loan UpdateLoan(Loan  L) ;
	public void deleteLoan(String idrequest);
	public int Score(Boolean isFilesOk , Loan Loan ,User  User , Loanlog Loan_log );

  
    
		
	
   
		
	}
   

	