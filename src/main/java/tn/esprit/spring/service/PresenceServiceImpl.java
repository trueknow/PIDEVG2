package tn.esprit.spring.service;


import tn.esprit.spring.entity.Presences;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service()
public class PresenceServiceImpl implements PresenceService{
    private List<Presences> Pres ;
   

    @Override
    public List<Presences> getPresences() {
        return Pres;
    }

    @Override
    public void addPresences(Presences Presences) {
    	Presences.add(Presences) ;
    }

    @Override
    public void UpdatePresences(Presences Presences) {
    	Presences.remove(Presences);
    	Presences.add(Presences);
    }

    @Override
    public void deletePresences(int P_id) {
    	Presences Presences=new Presences();
    
     Pres.remove(Presences) ;

    }
}