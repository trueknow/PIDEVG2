package tn.esprit.spring.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class EmployeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idbc;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
	private String firstName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
	private String lastName;
	@Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
	private String birthCity;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "marriedstatus")
    private boolean marriedstatus;
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public boolean getMarriedstatus() {
		return marriedstatus;
	}

	public void setMarriedstatus(boolean marriedstatus) {
		this.marriedstatus = marriedstatus;
	}

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
	private String job;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)

	private String jobemail;
	@Basic(optional = false)
    @NotNull
    
	
	private int salary;
	@Basic(optional = false)
    @NotNull
	private int valiDays=25;
	//mapppinng
	@OneToMany(mappedBy="EmployeInfo")
	private  List<Offdate> Offdates;

	public EmployeInfo() {
	}

	public Long getId() {
		return idbc;
	}

	public void setId(Long idbc) {
		this.idbc = idbc;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	public EmployeInfo(Long idbc, @Size(min = 1, max = 100) String firstName, @Size(min = 1, max = 100) String lastName,
			Date birthdate, @Size(min = 1, max = 100) String birthCity, boolean marriedstatus,
			@Size(min = 1, max = 100) String job, @Size(min = 1, max = 100) String jobemail, int salary, int valiDays) {
		super();
		this.idbc = idbc;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.birthCity = birthCity;
		this.marriedstatus = marriedstatus;
		this.job = job;
		this.jobemail = jobemail;
		this.salary = salary;
		this.valiDays = valiDays;
	}

	public int getValiDays() {
		return valiDays;
	}

	public void setValiDays(int valiDays) {
		this.valiDays = valiDays;
	}

	public String getJobemail() {
		return jobemail;
	}

	public void setJobemail(String jobemail) {
		this.jobemail = jobemail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
