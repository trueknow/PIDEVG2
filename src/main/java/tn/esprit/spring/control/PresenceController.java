package tn.esprit.spring.control;


import tn.esprit.spring.entity.Presences;
import tn.esprit.spring.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("http://localhost:8585")
@RequestMapping("/Presence")
public class PresenceController {

    @Autowired
    private PresenceService PresenceService ;

    @GetMapping
    public List<Presences> getProduits(){
        return PresenceService.getPresences();
    }
      @PostMapping
    public void addPresences(@RequestBody Presences Presences){
    	  PresenceService.addPresences(Presences);
    }

    @PutMapping
    public void UpdatePresences(@RequestBody Presences Presences){
    	PresenceService.UpdatePresences(Presences);
    }

    @DeleteMapping("/{ref}")
    public void deletePresences(@PathVariable  int P_id){
    	PresenceService.deletePresences(P_id);
    }

}