package tn.esprit.spring.control;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.VacationService;
import tn.esprit.spring.entity.Offdate;

import java.util.List;
//@CrossOrigin("http://localhost:3306")
@RestController
public class OffdateController {
    @Autowired
    private VacationService VacationService;

//najmou nekhdmouhom lkol b REQUEST MAPPING?????
    
    @GetMapping("/rest/getAllOffdate")
    @ResponseBody
    public List<Offdate>getAllUser(){
        List<Offdate> list = VacationService.getAllOffdates();
        return list;
    }

    
    @GetMapping("/rest/getbyidOffdate")
    @ResponseBody
    public Offdate getOffdate(String congeID){
    	Offdate Offdate = VacationService.getbyidOffdate( congeID);
        return Offdate;
    }

    
    @PostMapping("/rest/createOffdate")
    @ResponseBody
   public String createOffdate(@RequestBody Offdate v){
       
    	Offdate Offdate = VacationService.getbyidOffdate(Long.toString(v.getCongeID()));
        if(Offdate!=null){
           
            return "the Vacation has been registered,please register again";
       }else{
        	VacationService.createOffdate(v);
            return "the enployee with the vacation demand id  was  added";
        }
    }

    @DeleteMapping("/rest/deleteOffdate")
    @ResponseBody
    public String deleteOffdate(String congeID){
            	Offdate Offdate = VacationService.getbyidOffdate( congeID);
        if(Offdate != null){
        	VacationService.deleteOffdate( congeID);
            return "the VACATION has been deleted";
        }else{
            return "no found";
        }

    }

    @PutMapping("/rest/updateOffdate")
    @ResponseBody
   public String updateOffdate(@RequestBody Offdate v){
    	Offdate Offdate = VacationService.getbyidOffdate(Long.toString(v.getCongeID()));

        if(Offdate!=null){
        	VacationService.updateOffdate(v);
           return "update successfully";
        }else{
            return "update......no found";
        }

    }




}
