package tn.esprit.spring.repository;




import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Offdate;


@Repository
public interface VacationRepository extends JpaRepository<Offdate, Long>{
	
	@Query("select DISTINCT O from Offdate  O where O.id=:UserId")
	public List<Offdate> findAllOffdateByUserJPQL(@Param("UserId")int UserId);
	@Modifying
	@Transactional
	@Query("UPDATE Offdate e SET e.AdState='Accepted' where e.congeID=:id ")
	public void acceptOffdateJPQL(@Param("id") Long congeID);
	@Modifying
	@Transactional
	@Query("UPDATE Offdate e SET e.AdState='Inprogress' where e.congeID=:id ")
	public void InprogressOffdateJPQL(@Param("id") Long congeID);
	@Modifying
	@Transactional
	@Query("UPDATE Offdate e SET e.AdState='Denied' where e.congeID=:id")
	public void DeniedOffdateJPQL(@Param("id") Long congeID);
	@Query("SELECT startTime FROM Offdate WHERE congeID = ?1 ")
	public Date DateDebut(int congeID);

	@Query("SELECT endTime FROM Offdate WHERE congeID = ?1 ")
	public Date DateFin(int congeID);
	//conditions :duration max=25  and applying for this year
	@Query("SELECT u FROM Offdate u WHERE u.duration <= '25' and u.startTime LIKE '2021%' and u.endTime LIKE '2021%' ")
	public List<Offdate> findAllacceptableOffdate();
	@Query("select O  from Offdate O where O.AdState='Inprogress' ")
	public List<Offdate> MyInprogressList();
	
}
