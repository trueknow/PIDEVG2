package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Presences;


public interface PresenceService {
	
	public List<Presences> getAllPresences();
	public Presences getbyidPresences(String P_id);
	public Presences createPresences(Presences v, String User);
	public Presences updatePresences(Presences v );
	public void deletePresences(String P_id);
	

}
