package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="ratings")
public class Rating implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrating ;
    private int note ;
    @ManyToOne
    @JoinColumn(name="idpost")
    private Post post ;
    @ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
    
   
    
    

    
    public Rating (Long idrating  , int note   ) {
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