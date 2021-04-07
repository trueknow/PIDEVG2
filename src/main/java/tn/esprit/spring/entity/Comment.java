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
@Table(name ="comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcm ;
    private String description;
    private String date  ;
    @ManyToOne
    @JoinColumn(name="idpost")
    private Post post ;
   
    @ManyToOne
	@JoinColumn(name="ID_USER")
    
    private User user ;

    
    public Comment(long idcm  , String description , String date  ) {
        this.setIdcm(idcm);
        this.setDescription(description);
        this.setDate(date) ;
        
    }
    public Comment (){
    	
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
	public Comment(Long idcm, String description, String date, Post post, User user) {
		super();
		this.idcm = idcm;
		this.description = description;
		this.date = date;
		this.post = post;
		this.user = user;
	}
	
}
