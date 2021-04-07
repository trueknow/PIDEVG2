
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
@Table(name ="likes")
public class Like implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlike ;
	@ManyToOne
    @JoinColumn(name="idpost")
    private Post post ;
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
    
    
     public Like (Long idlike ) {
        this.setIdlike(idlike) ;
        
        
      
    }
     public Like (){
     	
     }

   
     public Long getIdlike() {
		return idlike;
	}





	public void setIdlike(Long idlike) {
		this.idlike = idlike;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Like(Long idlike, Post post, User user) {
		super();
		this.idlike = idlike;
		this.post = post;
		this.user = user;
	}



}