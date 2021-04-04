package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="T_Loan")
@Getter@Setter
public class Loan implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long idrequest ;	    
    private int iDCard;	    
    private int amount;
    private String payment_method;
    private String description  ; //PDF
    private String raison ;  //PDF
    private int duration;  
  
    

    
    public Loan( Long idrequest,int iDCard, String raison ,int duration ,String description
    		,int amount,String payment_method   ) 
    {
        this.idrequest = idrequest;
        this.iDCard=iDCard;
        this.raison= raison;
        this.description = description ;
        this.amount = amount ;
        this.duration = duration ; 
    }
        
       
    
}




	
 