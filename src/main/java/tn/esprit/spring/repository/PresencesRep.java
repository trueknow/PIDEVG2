package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Presences;

@Repository

public interface PresencesRep extends JpaRepository<Presences, Long> {
	
	//the admin can check who  is present or absent this day and he can do screen shot or save data in file
	@Query("select  O  from Presences O where O.present='1' ")
	public List<Presences> ListPresentEmpDaily();
	@Query("select O  from Presences O where O.present='0' ")
	public List<Presences> ListAbsentEmpDaily();
	
}
