package tn.esprit.spring.entity;



import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
	@Getter @Setter @Column(name="NAME")@NotBlank(message = "Display name required") @Size(min = 10) private String name;
	@Getter @Setter @Column(name="PRENAME")@NotBlank(message = "Display name required") @Size(min = 10) private String prename;
	@NotBlank(message = "E-mail required") @Column(name="MAIL")@Email(message = "E-mail invalid") @Getter @Setter private String email;
	@Getter @Setter @Column(name="PASSWORD")@NotBlank(message = "Password required") @Min(6) @Max(60) private  String password;
	@Getter @Setter@Column(name="ACTIVE") private  Boolean isActive = false;
	@Getter @Setter private  ProfileEnum profile;
	
	
	

}


