package tn.esprit.spring.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.EmployeInfo;


@Repository
public interface EmployeInfoRep extends JpaRepository<EmployeInfo, Long>{
	@Query("SELECT u FROM EmployeInfo u WHERE u.job ='financer' ")
	public List<EmployeInfo> findAllFinancers();
	@Query("SELECT u FROM EmployeInfo u WHERE u.job ='manager' ")
    public List<EmployeInfo> findAllManagers();
	@Query("SELECT u FROM EmployeInfo u WHERE u.job ='PDG' ")
	public List<EmployeInfo> findAllPDGs();
	@Query("SELECT u FROM EmployeInfo u WHERE u.marriedstatus ='1' ")
	public List<EmployeInfo> findAllmarriedemp();
	@Query("SELECT u FROM  EmployeInfo u  ORDER BY u.salary DESC ")
	public List<EmployeInfo> findAllempBySalary();
	
	
	
	
	
}
