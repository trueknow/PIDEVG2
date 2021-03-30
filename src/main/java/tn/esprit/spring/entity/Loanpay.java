package tn.esprit.spring.entity;
//package tn.esprit.spring.validation;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column; 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import javax.validation.constraints.Pattern;
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table( name = "loan_log")
public class Loanpay implements Serializable{
	@Id
	@Setter
	@Getter
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idrequest")
	private int id;
	@Getter
	@Setter
	@Column(name = "Amount")
	@NotEmpty(message = "Amount required") 
	private String Amount;
	@Getter @Setter @Column(name="Date")@NotEmpty(message = "Verify the Date") 
	private Date Date;
	@Getter @Setter @Column(name="Status")@NotEmpty(message = "verify the status") 
	private  String Status;
	//public Long getId() {return id;}
	
	//public void setId(Long id) {this.id = id;}
	
	
	
	
	
	
}
//@Pattern(regexp="AA/BB/CCCC", 
//message="verify the date ")
//public String getDate() {
//return Date;}


////this.Date = Date; }//