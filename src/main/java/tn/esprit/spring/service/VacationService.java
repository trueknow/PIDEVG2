package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Offdate;

public interface VacationService {
	
	public List<Offdate> getAllOffdates();
	public Offdate getbyidOffdate(String congeID);
	public Offdate createOffdate(Offdate v);
	public Offdate updateOffdate(Offdate v );
	public void deleteOffdate(String congeID);

}