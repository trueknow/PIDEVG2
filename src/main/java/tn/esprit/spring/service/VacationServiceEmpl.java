package tn.esprit.spring.service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.AdState;
import tn.esprit.spring.entity.Offdate;
import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.repository.VacationRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class VacationServiceEmpl implements VacationService{

@Autowired
	VacationRepository VacationRepository ;
@Autowired
UserRepository UserRepository ;


	private static final Logger L = LogManager.getLogger(VacationServiceEmpl.class);

	@Override
	public List<Offdate> getAllOffdates(){

		List<Offdate> Vacations = (List<Offdate>) VacationRepository.findAll();
		for(Offdate Vacation : Vacations)
			L.info("Vacation +++ : " + Vacation);

		return Vacations;

	}

	
	@Override
	public Offdate getbyidOffdate(String congeID){
		L.info("in retrieveOffdate id = " +  congeID);
		
		Offdate O = VacationRepository.findById(Long.parseLong( congeID)).orElse(null);
		
		L.info("Vacation returned :" + O);
		
		return O ;

	}
	@Override
	public Offdate createOffdate(Offdate v, String UserId,String User1Id){
		v.setAdState(AdState.Inprogress);
		Offdate	OffdateSaved = VacationRepository.save(v);
		
		DAOUser user = UserRepository.findById(Long.parseLong( UserId)).orElse(null);
		System.out.println(user.getId());
		
		v.setDAOUser(user);
		DAOUser user1 = UserRepository.findById(Long.parseLong( User1Id)).orElse(null);
		System.out.println(user.getId());
		v.setDAOUser1(user1);
		 VacationRepository.save(v);

		
		return OffdateSaved;
	}
	@Override
	public Offdate updateOffdate(Offdate v){

		return VacationRepository.save(v);
	}
	
	@Override
	public void deleteOffdate(String congeID){
		
		VacationRepository.deleteById(Long.parseLong( congeID));
	}
	//@Override
	//public boolean verifConditions(String userid,int duration){
		//int d =Vs.getOffdateDurationbyId(Long.parseLong(userid), 2000);
		//if (d+duration>25) {
			  //System.out.println("you cant apply for this vacation");
			  //return false;
			//}
		//return true;
	//}
	@Override
	public List<Offdate> findAllOffdateByUserJPQL(int UserId){
		return VacationRepository.findAllOffdateByUserJPQL(UserId);
		
	}
	public long calculateDateInterval(Date startDate, Date endDate) {
		return ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
		
	}
	public void acceptOffdateJPQL(Long congeID) {
		VacationRepository.acceptOffdateJPQL(congeID);
		
	}
	public void DeniedOffdateJPQL(Long congeID) {
		VacationRepository.DeniedOffdateJPQL(congeID);
		
	}
	public void InprogressOffdateJPQL(Long congeID) {
		VacationRepository.InprogressOffdateJPQL(congeID);
		
	}
	public List<Offdate> MyInprogressList() {
		List<Offdate> my =VacationRepository.MyInprogressList();
		return  my;
}
	public List<Offdate> findAllacceptableOffdate() {
		List<Offdate> acceptable =VacationRepository.findAllacceptableOffdate();
		return  acceptable;
}
}
