package tn.esprit.spring.entity;





import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;




import lombok.Getter;

import lombok.Setter;
import tn.esprit.spring.entity.AdState;



@Entity
@Table( name = "Offdate")
public class Offdate  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @Setter @Getter @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long congeID ;
	


    
    private Date startTime  ;
    private Date endTime  ;
    private int duration;
	private String status;
    private String pic;
    @Enumerated(EnumType.STRING)
	AdState AdState;
   
    @ManyToOne
   	private DAOUser DAOUser;
    
    @ManyToOne
   	private DAOUser DAOUser1;
    @ManyToOne
    @JoinColumn(name = "idemp", referencedColumnName = "idbc", insertable=false, updatable=false)
	private EmployeInfo EmployeInfo;

	public Long getCongeID() {
		return congeID;
	}

	public void setCongeID(Long congeID) {
		this.congeID = congeID;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	

	
	public DAOUser getDAOUser() {
		return DAOUser;
	}

	public void setDAOUser(DAOUser DAOUser) {
		this.DAOUser = DAOUser;
	}

	public DAOUser getDAOUser1() {
		return DAOUser1;
	}

	public void setDAOUser1(DAOUser DAOUser1) {
		this.DAOUser1 = DAOUser1;
	}

	public Offdate(Long congeID, Date startTime, Date endTime, int duration, String status, String pic,
			tn.esprit.spring.entity.AdState adState, DAOUser DAOUser, DAOUser DAOUser1,
			tn.esprit.spring.entity.EmployeInfo employeInfo) {
		super();
		this.congeID = congeID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.status = status;
		this.pic = pic;
		AdState = adState;
		this.DAOUser = DAOUser;
		this.DAOUser1 = DAOUser1;
		EmployeInfo = employeInfo;
	}
	public Offdate() {
		super();
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public AdState getAdState() {
		return AdState;
	}

	public void setAdState(AdState adState) {
		AdState = adState;
	}

	public EmployeInfo getEmployeInfo() {
		return EmployeInfo;
	}

	public void setEmployeInfo(EmployeInfo employeInfo) {
		EmployeInfo = employeInfo;
	}

	
   
    

    
    }
