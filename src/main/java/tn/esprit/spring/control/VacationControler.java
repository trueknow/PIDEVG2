package tn.esprit.spring.control;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entity.Vacation;
import tn.esprit.spring.service.Vacationservice;

@RestController

@CrossOrigin("http://localhost:8585")
@RequestMapping("/Vacation")

public class VacationControler {
	@Autowired
    private Vacationservice Vacationservices ;

    @GetMapping
    public List<Vacation> getVacations(){
        return Vacationservices.getVacation();
    }
      @PostMapping
    public void addVacation(@RequestBody Vacation Vacation){
    	  ((Vacationservice) Vacationservices).addVacation(Vacation);
    }

    @PutMapping
    public void UpdateVacation(@RequestBody Vacation Vacation){
    	Vacationservices.UpdateVacation(Vacation);
    }

    @DeleteMapping("/{congeID}")
    public void deleteProduit(@PathVariable  String congeID){
    	Vacationservices.deleteVacation(congeID);
    }

}
