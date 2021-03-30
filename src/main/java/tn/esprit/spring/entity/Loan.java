package tn.esprit.spring.entity;

public class Loan {
	
    private String idrequest ;	    
    private int iDCard;	    
    private int amount;
    private String payment_method;
    private String description  ; //PDF
    private String raison ;  //PDF
    private int duration;  }
  
    

    
    public Loan( String idrequest,int iDCard, String raison ,int duration ,String description
    		,int amount,String payment_method   ) 
    {
        this.idrequest = idrequest;
        this.iDCard=iDCard;
        this.raison= raison;
        this.description = description ;
        this.amount = amount ;
        this.duration = duration ; 
    }
        
       
    





	
 