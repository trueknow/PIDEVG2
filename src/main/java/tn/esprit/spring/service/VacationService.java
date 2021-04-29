package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Offdate;
import tn.esprit.spring.entity.User;

public interface VacationService {
	
	public List<Offdate> getAllOffdates();
	public Offdate getbyidOffdate(String congeID);
	public Offdate createOffdate(Offdate v,String UserId,String User1Id);
	public Offdate updateOffdate(Offdate v );
	public void deleteOffdate(String congeID);
	//public boolean verifConditions(String userid,int duration);
	public List<Offdate> findAllOffdateByUserJPQL(int UserId);
	

}
