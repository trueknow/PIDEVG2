package tn.esprit.spring.entity;



import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Set;

import tn.esprit.spring.entity.*;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "T_USER")
public class User  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
	@Getter @Setter @Column(name="NAME")@NotBlank(message = "Display name required") @Size(min = 10) private String name;
	@Getter @Setter @Column(name="PRENAME")@NotBlank(message = "Display name required") @Size(min = 10) private String prename;
	@NotBlank(message = "E-mail required") @Column(name="MAIL")@Email(message = "E-mail invalid") @Getter @Setter private String email;
	@Getter @Setter @Column(name="PASSWORD")@NotBlank(message = "Password required") @Min(6) @Max(60) private  String password;
	@Getter @Setter@Column(name="ACTIVE") private  Boolean isActive = false;
	@Getter @Setter @Enumerated(EnumType.STRING)private  ProfileEnum profile;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )
	private Set<Comment> Comment;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )
	private Set<Like> Like;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )	
	private Set<Rating> Rating;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )
	private Set<Post> Post;

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )
	private Set<Topic> Topic;
	

	@OneToMany (cascade = CascadeType.ALL, mappedBy ="user" )
	private Set<Offdate> offdate;
	
	@OneToOne(mappedBy="user")
	private Account account;
	@OneToOne(mappedBy="user")
	private Presences presences;
	
	public User( @NotBlank(message = "Display name required ") @Size(min = 4) String name,
			@NotBlank(message = "Display name required") @Size(min = 4) String prename,
			@NotBlank(message = "E-mail required") @Email(message = "E-mail invalid") String email,
			@NotBlank(message = "Password required") @Min(6) @Max(60) String password, Boolean isActive,
			ProfileEnum profile) {
		super();
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.profile = profile;
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


