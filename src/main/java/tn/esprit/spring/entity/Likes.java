
package tn.esprit.spring.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="likes")
public class Likes implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idlike ;
    
    
     public Likes (Long idlike ) {
        this.setIdlike(idlike) ;
        
        
      
    }
     public Likes (){
     	
     }

   
     public Long getIdlike() {
		return idlike;
	}





	public void setIdlike(Long idlike) {
		this.idlike = idlike;
	}



}