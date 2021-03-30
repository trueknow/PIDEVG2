package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="posts")

public class Posts implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpost ;
    private String descriptionpost;
    private String datepost ;
   
    
    

    
    public Posts(Long idpost  , String descriptionpost , String datepost  ) {
        this.setIdpost(idpost);
        this.setDescriptionpost(descriptionpost);
        this.setDatepost(datepost) ;
        
    }

   

	


	public String getDescriptionpost() {
		return descriptionpost;
	}



	public void setDescriptionpost(String descriptionpost) {
		this.descriptionpost = descriptionpost;
	}



	public String getDatepost() {
		return datepost;
	}



	public void setDatepost(String datepost) {
		this.datepost = datepost;
	}



    public Long getIdpost() {
		return idpost;
	}






	public void setIdpost(Long idpost) {
		this.idpost = idpost;
	}
	
}