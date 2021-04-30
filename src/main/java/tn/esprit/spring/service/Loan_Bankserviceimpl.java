package tn.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.Loanrep;
import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.entity.Loan_Bank;
import tn.esprit.spring.repository.Loanbankrep;
import tn.esprit.spring.entity.Payment_method;
@Service
public class Loan_Bankserviceimpl implements Loan_BankService {
	@Autowired
	Loanbankrep Loanbankrep ;
	@Autowired
	Loanrep Loanrep ;

	private static final Logger LB = LogManager.getLogger(Loan_Bankserviceimpl.class);
    @Override
	public Loan_Bank addLoan_Bank(Loan_Bank LB){
		Loan_Bank LoanSaved = null ;
		LoanSaved = Loanbankrep.save(LB);
		return LoanSaved;}
	
    @Override
	public Loan_Bank getbyidrequest(String idrequest)
	{
    	LB.info("in retrieveLoan idrequest = " + idrequest);
		
    	Loan_Bank lb = Loanbankrep.findById(Long.parseLong(idrequest)).orElse(null);
		
    	LB.info("Loan returned :" + lb);
		return lb ;}
    
    
    @Override
	public void deleteLoan_Bank(String idrequest){
		
    	Loanbankrep.deleteById(Long.parseLong(idrequest)) ;
    
    }
    @Override
    public void calculamount(String idrequest ,double amount) {
    	Loan_Bank LB = Loanbankrep.findById(Long.parseLong(idrequest)).get();
    	Loan Lo = LB.getLoan();
    	LB.setTATP(amount*0.05);
    }
    
   
	@Override
    public void calculpayment(String idrequest ,double TATP,double PWI){
    Loan_Bank LB = Loanbankrep.findById(Long.parseLong(idrequest)).get();
    Loan Lo = LB.getLoan();
      if ( LB.getTATP()<10000000)
      { LB.setPP("one year");//ajouter a la case payment period 1 an
    	  switch(Lo.getPayment_method()){
    	  case monthly :  LB.setPWI(TATP/12);
    	  case quarterly : LB.setPWI(TATP/4);
    	  case semester : LB.setPWI(TATP/2);}}
    	  else if (LB.getTATP()<30000000){
           LB.setPP("two years");
           switch(Lo.getPayment_method()){
    	      case monthly : LB.setPWI(TATP/24);
    	      case quarterly : LB.setPWI(TATP/8);
    	       case semester : LB.setPWI(TATP/4);}}
    	  else if  (LB.getTATP()<50000000){
            LB.setPP("three years");
            switch(Lo.getPayment_method()){
    	       case monthly:  LB.setPWI(TATP/36);
    	       case quarterly : LB.setPWI(TATP/12);
    	       case semester : LB.setPWI(TATP/6);}}
    	  else { 
    		  LB.setPP("five years");
              switch(Lo.getPayment_method()){
    	         case monthly : LB.setPWI(TATP/60);
    	         case quarterly : LB.setPWI(TATP/20);
    	         case semester : LB.setPWI(TATP/10);}
    	  }
    
      
      
    }       
    }
      
  





