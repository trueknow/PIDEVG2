package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.esprit.spring.entity.Presences;
import tn.esprit.spring.service.PresencesListWrapper;
//import tn.esprit.spring.entity.user; 
import tn.esprit.spring.repository.PresencesRep;

@Controller
public class PresencesController {
	
	private PresencesRep repository;
	
	PresencesController(PresencesRep PresencesRep) {
	      this.repository = PresencesRep;
	  }

	// CRUD methods here
	
	@GetMapping("/check_presence")
    public String checkPresences(Model model) {
		List<employees> empty_employees_list = new ArrayList<employees>();
		PresencesListWrapper  empty_presences_wrp = new PresencesListWrapper();
		List<Presences> empty_presences_list = new ArrayList<Presences>();
		empty_presences_wrp.setPresencesList(empty_presences_list);
		model.addAttribute("employees_list", empty_employees_list);
		model.addAttribute("presences_wrp", empty_presences_wrp);
        return "check_presence";
    }
	
	@GetMapping("/presences")
    public String showAllPresences(Model model) {
		model.addAttribute("presences_list", repository.findAll());
		model.addAttribute("presence_object", new Presences());
        return "presences";
    }
	
	@GetMapping("/edit_presence/{id}")
    public String editPresences(@PathVariable("id") Long id, Model model) {
		Presences presence_obj = repository.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid presence Id:" + id));
		model.addAttribute("presence_object", presence_obj);
        return "edit_presence";
    }
	
	@GetMapping("/delete_presence/{id}")
	public String deletePresences(@PathVariable("id") Long id, Model model) {
		Presences presence_obj = repository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid presence Id:" + id));
	    repository.delete(presence_obj);
	    model.addAttribute("presences_list", repository.findAll());
		model.addAttribute("presence_object", new Presences());
	    return "presences";
	}
	
	@PostMapping("/presences")
	public String createPresences(@ModelAttribute Presences presence_object, Model model){
	    repository.save(presence_object);
	    return "success";
	}
	
	@PostMapping("/edit_presence/{id}")
	public String editPresences(@PathVariable("id") long id, Presences presence_object, Model model){
	    repository.save(presence_object);
	    return "success";
	}
	
	@PostMapping("/save_presences")
	public String savePresences(@ModelAttribute PresencesListWrapper presences_wrp, Model model){
		System.out.println("Got inside the controller");
		System.out.println("The presence wrp is: " + presences_wrp.getPresencesList());
		for (Presences presence : presences_wrp.getPresencesList()) {
			// Create a transaction logic for each row (Better than batch saving):
			repository.save(presence);
		}
	    return "success";
	}

}
