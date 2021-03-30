package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pictures")
public class Pictures implements Serializable {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpic ;
    
    
   
    
    

    
    public Pictures (Long idpic ) {
        this.setIdpic(idpic) ;
        
        
      
    }







	public Long getIdpic() {
		return idpic;
	}







	public void setIdpic(Long idpic) {
		this.idpic = idpic;
	}



}



	