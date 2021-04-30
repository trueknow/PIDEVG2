package tn.esprit.spring.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.EmployeInfo;

import tn.esprit.spring.service.EmployeInfoService;
import tn.esprit.spring.service.EmployeInfoServiceImpl;

@RestController
public class EmployeController {
	@Autowired
	EmployeInfoService EmployeInfoService;
	@Autowired
	EmployeInfoServiceImpl ec ;
    
	@GetMapping("/GETall-EmployeInfo")
	@ResponseBody
	public List<EmployeInfo> getAllEmployeInfo() {
	List<EmployeInfo> list = EmployeInfoService.getAllEmployeInfo();
	return list;
	}

	@GetMapping("/getEmployeInfo/{idbc}")
	@ResponseBody
	 public EmployeInfo getbyidEmployeInfo(@PathVariable("idbc") String id) {
	 return EmployeInfoService.getbyidEmployeInfo(id);
	 }
    
	@PostMapping("/add-EmployeInfo")
	@ResponseBody
	public EmployeInfo createOffdate(@RequestBody EmployeInfo v) {
		EmployeInfo aa = EmployeInfoService.createEmployeInfo(v);
	 return aa;
	 }
	@GetMapping(value = "/findAllFinancers")
	public List<EmployeInfo> findAllFinancers(){
		List<EmployeInfo> list = ec.findAllFinancers();
		return list;
	}
	@GetMapping(value = "/findAllManagers")
	public List<EmployeInfo> findAllManagers(){
		List<EmployeInfo> list = ec.findAllManagers();
		return list;
	}
	@GetMapping(value = "/findAllPDGs")
	public List<EmployeInfo> findAllPDGs(){
		List<EmployeInfo> list = ec.findAllPDGs();
		return list;
	}
	@GetMapping(value = "/findAllmarriedemp")
	public List<EmployeInfo> findAllmarriedemp(){
		List<EmployeInfo> list = ec.findAllmarriedemp();
		return list;
	}
	@GetMapping(value = "/findAllempBySalary")
	public List<EmployeInfo> findAllempBySalary(){
		List<EmployeInfo> list = ec.findAllempBySalary();
		return list;
	}
	
}
