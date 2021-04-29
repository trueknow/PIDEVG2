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


import tn.esprit.spring.entity.Presences;
import tn.esprit.spring.service.PresenceService;
import tn.esprit.spring.service.PresenceServiceImpl;

@RestController
public class PresenceController {
	@Autowired
	PresenceService PresenceService;
	@Autowired
	PresenceServiceImpl ps;
    //1
	@GetMapping("/GETall-Presences")
	@ResponseBody
	public List<Presences> getPresences() {
	List<Presences> list = PresenceService.getAllPresences();
	return list;
	}
	//2
	@GetMapping("/getPresences/{P_id}")
	@ResponseBody
	 public Presences getbyidPresences(@PathVariable("P_id") String Pid) {
	 return PresenceService.getbyidPresences(Pid);
	 }
    //3
	@PostMapping("/add-Presences/{id}")
	@ResponseBody
	public Presences createPresences(@RequestBody Presences v,@PathVariable("id") String User) {
		Presences P = PresenceService.createPresences(v,User);
	 return P;
	 }
	//4
	@DeleteMapping("/delete-Presences/{P_id}")
	@ResponseBody
	public ResponseEntity<String> removeComment(@PathVariable("P_id") String Pid) {
		PresenceService.deletePresences(Pid);
		return new ResponseEntity<String>("vacation deleted successfully",HttpStatus.OK);
	 }
    //5
	@PutMapping("/modify-Presences")
	@ResponseBody
	 public Presences modifyPresences (@RequestBody Presences Presences) {
	 return PresenceService.updatePresences(Presences);
	 }
	
	@GetMapping(value = "/ListPresentEmpDaily")
	public List<Presences> ListPresentEmpDaily(){
		List<Presences> list = ps.ListPresentEmpDaily();
		return list;
	}
	@GetMapping(value = "/ListAbsentEmpDaily")
	public List<Presences> ListAbsentEmpDaily(){
		List<Presences> list = ps.ListAbsentEmpDaily();
		return list;
	}
	

}
