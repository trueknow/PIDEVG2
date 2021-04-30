package tn.esprit.spring.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Presences;
import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.repository.PresencesRep;
import tn.esprit.spring.repository.UserRepository;

@Service
public class PresenceServiceImpl implements PresenceService{

@Autowired
PresencesRep PresencesRep ;
@Autowired
UserRepository UserRepository; 


	private static final Logger L = LogManager.getLogger(VacationServiceEmpl.class);

	@Override
	public List<Presences> getAllPresences(){

		List<Presences> Presences = (List<Presences>) PresencesRep.findAll();
		for(Presences Presence : Presences)
			L.info("Presence +++ : " + Presence);

		return Presences;

	}

	
	@Override
	public Presences getbyidPresences(String P_id){
		L.info("in retrievePresences id = " +  P_id);
		
		Presences O = PresencesRep.findById(Long.parseLong( P_id)).orElse(null);
		
		L.info("Presences returned :" + O);
		return O ;

	}
	@Override
	public Presences createPresences(Presences v, String User){

		Presences	pSaved = PresencesRep.save(v);
		
		DAOUser user = UserRepository.findById(Long.parseLong( User)).orElse(null);
		System.out.println(user.getId());
		
		v.setDAOUser(user);
		return pSaved;
	}
	@Override
	public Presences updatePresences(Presences v){

		return PresencesRep.save(v);
	}
	
	@Override
	public void deletePresences(String P_id){
		
		PresencesRep.deleteById(Long.parseLong( P_id));
	}

	
	public List<Presences> ListPresentEmpDaily() {
		List<Presences> work =PresencesRep.ListPresentEmpDaily();
		return  work;
}
	public List<Presences> ListAbsentEmpDaily() {
		List<Presences> work =PresencesRep.ListAbsentEmpDaily();
		return  work;
}
}
