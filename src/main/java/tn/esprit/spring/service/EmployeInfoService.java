package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entity.EmployeInfo;

public interface EmployeInfoService {
	
	public List<EmployeInfo> getAllEmployeInfo();
	public EmployeInfo getbyidEmployeInfo(String id);
	public EmployeInfo createEmployeInfo(EmployeInfo v);
	public EmployeInfo updateEmployeInfo(EmployeInfo v );
}