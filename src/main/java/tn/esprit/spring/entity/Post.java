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
@Table(name ="posts")

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpost ;
    private String descriptionpost;
    private String datepost ;
    private String path ;
    @OneToMany (cascade = CascadeType.ALL, mappedBy ="post" )
   private Set<Comment> Comment;
    @OneToMany (cascade = CascadeType.ALL, mappedBy ="post" )
    private Set<Like> Like ;
    @OneToMany (cascade = CascadeType.ALL, mappedBy ="post" )
    private Set<Rating> Rating;
    @ManyToOne
    @JoinColumn(name="idTopic")
    private Topic topic ;
    @ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
    
    

    
    public Post(Long idpost  , String descriptionpost , String datepost , String path  ) {
        this.setIdpost(idpost);
        this.setDescriptionpost(descriptionpost);
        this.setDatepost(datepost) ;
        this.setpath(path);
        
        
        
    }

   public String getDescriptionpost() {
		return descriptionpost;
	}



	public void setpath(String path) {
		this.path = path;
	}
	 public String getpath() {
			return path;
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