package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ratings")
public class Ratings implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrating ;
    private int note ;
    
   
    
    

    
    public Ratings (Long idrating  , int note   ) {
        this.setIdrating(idrating) ;
        this.setnote(note) ;
        
      
    }

 



	public int getnote() {
		return note;
	}



	public void setnote(int note) {
		this.note = note;
	}







	public Long getIdrating() {
		return idrating;
	}







	public void setIdrating(Long idrating) {
		this.idrating = idrating;
	}
	
}