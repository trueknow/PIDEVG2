package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="comments")
public class Comments {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcm ;
    private String description;
    private String date  ;
   
    
    

    
    public Comments(long idcm  , String description , String date  ) {
        this.setIdcm(idcm);
        this.setDescription(description);
        this.setDate(date) ;
        
    }
    public Comments (){
    	
    }

   
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}






	public Long getIdcm() {
		return idcm;
	}






	public void setIdcm(Long idcm) {
		this.idcm = idcm;
	}
	
}