package tn.esprit.spring.service;

import tn.esprit.spring.entity.Presences;

import java.util.List;

public interface PresenceService {

    List<Presences> getPresences() ;
    void addPresences(Presences Presences ) ;
    void UpdatePresences(Presences Presences) ;
    void deletePresences(int p_id) ;
}
