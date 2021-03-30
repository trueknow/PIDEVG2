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



import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.service.Loanser;

@RestController

@CrossOrigin("http://localhost:8585")
@RequestMapping("/Loan")

public class Loancontroller {
	@Autowired
    private Loanser Loanservices ;

    @GetMapping
    public List<Loan> getLoan(){
        return Loanservices.getLoan();
    }
      @PostMapping
    public void addLoan(@RequestBody Loan Loan){
    	  ((Loanser) Loanservices).addLoan(Loan);
    }

    @PutMapping
    public void UpdateLoan(@RequestBody Loan Loan){
    	Loanservices.UpdateLoan(Loan);
    }

    @DeleteMapping("/{idrequest}")
    public void deleteLoan(@PathVariable  String idrequest){
    	Loanservices.deleteLoan(idrequest);
    }

}