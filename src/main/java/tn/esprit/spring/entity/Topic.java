package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="topics")

public class Topic implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTopic ;
    private String descriptionTopic;
    @OneToMany (cascade = CascadeType.ALL, mappedBy ="Topic" )
    private Set<Post> Post;
    @ManyToOne
	@JoinColumn(name="ID_USER")
    
    private User user ;

   
    
    

    
    public Topic(Long idTopic  , String descriptionTopic  ) {
        this.setIdTopic(idTopic);
        this.setDescriptionTopic(descriptionTopic);
     
        
    }

   

	


	public String getDescriptionTopic() {
		return descriptionTopic;
	}



	public void setDescriptionTopic(String descriptionTopic) {
		this.descriptionTopic = descriptionTopic;
	}

	public Long getIdTopic() {
		return idTopic;
	}






	public void setIdTopic(Long idTopic) {
		this.idTopic = idTopic;
	}
}

	
