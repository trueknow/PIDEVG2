package tn.esprit.spring.entity;



//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;



import java.io.Serializable;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;



@AllArgsConstructor
@Entity
@Table( name = "T_USER")
public class DAOUser  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
    @Column(name="NAME")private String name;
	@Column(name="PRENAME") private String prename;
    @Column(name="MAIL")private String email;
	@Column(name="PASSWORD") private  String password;
	@Column(name="ACTIVE") private  Boolean isActive = false;
	@Enumerated(EnumType.STRING)private  ProfileEnum profile;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )
	private Set<Comment> Comment;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )
	private Set<Like> Like;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )	
	private Set<Rating> Rating;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )
	private Set<Post> Post;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )
	private Set<Topic> Topic;
	

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="DAOUser" )
	private Set<Offdate> offdate;
	
	@OneToOne(mappedBy="DAOUser")
	private Account account;
	@OneToOne(mappedBy="DAOUser")
	private Presences presences;
	@OneToOne
	private Loan loan;
        @OneToOne
	private Loan_Management loan_Management;
 @OneToMany(cascade = CascadeType.ALL, mappedBy="DAOUser")
        private Set<Loanlog>Loanlog ;
	
	public DAOUser(  String name,
			 String prename,
			 String email,
			 String password, Boolean isActive,
			ProfileEnum profile) {
		super();
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.profile = profile;
	}


	public DAOUser() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrename() {
		return prename;
	}


	public void setPrename(String prename) {
		this.prename = prename;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public ProfileEnum getProfile() {
		return profile;
	}


	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}


