package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Offdate;

import tn.esprit.spring.repository.VacationRepository;

@Service
public class VacationServiceEmpl implements VacationService{


	VacationRepository VacationRepository ;

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
	public Offdate createOffdate(Offdate v){

		Offdate OffdateSaved = null ;
		OffdateSaved = VacationRepository.save(v);
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

}
