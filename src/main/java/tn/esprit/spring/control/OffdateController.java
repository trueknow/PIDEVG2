package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Offdate;
import tn.esprit.spring.service.VacationService;
import tn.esprit.spring.service.VacationServiceEmpl;

@RestController
public class OffdateController {
	@Autowired
	VacationService VacationService;
	@Autowired
	VacationServiceEmpl vc ;
    //admin role
	@GetMapping("/GETall-Offdates")
	@ResponseBody
	public List<Offdate> getOffdates() {
	List<Offdate> list = VacationService.getAllOffdates();
	return list;
	}
	//admin role
	@GetMapping("/getOffdate/{congeID}")
	@ResponseBody
	 public Offdate getbyidOffdate(@PathVariable("congeID") String coId) {
	 return VacationService.getbyidOffdate(coId);
	 }
    //employee role
	@PostMapping("/add-Offdate/{id}/{id1}")
	@ResponseBody
	public Offdate createOffdate(@RequestBody Offdate v,@PathVariable("id") String UserId,@PathVariable("id1")String User1Id) {
		Offdate Offd = VacationService.createOffdate(v,UserId,User1Id);
	 return Offd;
	 }
	//admin role
	@DeleteMapping("/delete-Offdate/{congeID}")
	@ResponseBody
	public ResponseEntity<String> removeComment(@PathVariable("congeID") String coID) {
		VacationService.deleteOffdate(coID);
		return new ResponseEntity<String>("vacation deleted successfully",HttpStatus.OK);
	 }
    
	@PutMapping("/modify-Offdate")
	@ResponseBody
	 public Offdate modifyOffdate (@RequestBody Offdate Offdate) {
	 return VacationService.updateOffdate(Offdate);
	 }
	//Admin Role
	@GetMapping(value = "findAlloffdatesbyuid/{Sender}")
    @ResponseBody
	public List<Offdate> findAllOffdateByUserJPQL(@PathVariable("Sender") int UserId) {

		return VacationService.findAllOffdateByUserJPQL(UserId);
	}
	//Admin Role
	@PutMapping("/update-vacAccepted/{congeID}")
  	@ResponseBody
  	public ResponseEntity<String> updatevacaccepted(@PathVariable("congeID")Long congeID) {
		
		vc.acceptOffdateJPQL(congeID);
  		return new ResponseEntity<String>("vacation updated successfully",HttpStatus.OK);
  		
  	}
	//Admin role
	@PutMapping("/update-vacDenied/{congeID}")
  	@ResponseBody
  	public ResponseEntity<String> updatevacDenied(@PathVariable("congeID")Long congeID) {
		
		vc.DeniedOffdateJPQL(congeID);
  		return new ResponseEntity<String>("vacation updated successfully",HttpStatus.OK);
  		
  	}
	//employee role
	@PutMapping("/update-vacInprogress/{congeID}")
  	@ResponseBody
  	public ResponseEntity<String> updatevacInprogress(@PathVariable("congeID")Long congeID) {
		
		vc.InprogressOffdateJPQL(congeID);
  		return new ResponseEntity<String>("vacation in progress",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/MyInprogressList")
	public List<Offdate> MyInprogressList(){
		List<Offdate> list = vc.MyInprogressList();
		return list;
	}
	@GetMapping(value = "/acceptableList")
	public List<Offdate> findAllacceptableOffdate(){
		List<Offdate> list = vc.findAllacceptableOffdate();
		return list;
	}

}
