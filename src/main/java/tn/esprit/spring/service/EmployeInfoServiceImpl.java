package tn.esprit.spring.service;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.EmployeInfo;
import tn.esprit.spring.entity.Presences;
import tn.esprit.spring.repository.EmployeInfoRep;

@Service
public class EmployeInfoServiceImpl implements EmployeInfoService{

@Autowired
EmployeInfoRep EmployeInfoRep ;


	private static final Logger L = LogManager.getLogger(EmployeInfoServiceImpl.class);

	@Override
	public List<EmployeInfo> getAllEmployeInfo(){

		List<EmployeInfo> EmployeInfo = (List<EmployeInfo>) EmployeInfoRep.findAll();
		for(EmployeInfo e : EmployeInfo)
			L.info("e +++ : " + e);

		return EmployeInfo;

	}

	
	@Override
	public EmployeInfo getbyidEmployeInfo(String id){
		L.info("in retrieveOffdate id = " +  id);
		
		EmployeInfo O = EmployeInfoRep.findById(Long.parseLong( id)).orElse(null);
		
		L.info("EmployeInfo returned :" + O);
		return O ;

	}
	@Override
	public EmployeInfo createEmployeInfo(EmployeInfo v){

		EmployeInfo EmployeInfoSaved = null ;
		EmployeInfoSaved = EmployeInfoRep.save(v);
		return EmployeInfoSaved;
	}
	@Override
	public EmployeInfo updateEmployeInfo(EmployeInfo v){

		return EmployeInfoRep.save(v);
	}
	public List<EmployeInfo> findAllFinancers() {
		List<EmployeInfo> work =EmployeInfoRep.findAllFinancers();
		return  work;
	}
	public List<EmployeInfo> findAllManagers() {
		List<EmployeInfo> work =EmployeInfoRep.findAllManagers();
		return  work;
	}
	public List<EmployeInfo> findAllPDGs() {
		List<EmployeInfo> work =EmployeInfoRep.findAllPDGs();
		return  work;
	}
	public List<EmployeInfo> findAllmarriedemp() {
		List<EmployeInfo> work =EmployeInfoRep.findAllmarriedemp();
		return  work;
	}
	public List<EmployeInfo> findAllempBySalary() {
		List<EmployeInfo> work =EmployeInfoRep.findAllempBySalary();
		return  work;
	}
	
	
	
	
	
}