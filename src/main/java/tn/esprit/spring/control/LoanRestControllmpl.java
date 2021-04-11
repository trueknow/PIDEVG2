package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.service.LoanService;
//@CrossOrigin("http://localhost:3306")
@RestController
public class LoanRestControllmpl {
	    @Autowired
	    LoanService loanservice;
	    
	    // http://localhost:8089/SpringMVC/servlet/get_ALL_Loan
		@GetMapping("/get_ALL_Loan")
		@ResponseBody
		public List<Loan> getALLLoan() {
		List<Loan> list = loanservice.getALLLoan();
		return list;
		}
		
		//http://localhost:8089/SpringMVC/servlet/getbyidrequest-loan/{loan-idrequest}
		@GetMapping("/getbyidrequest-loan/{loan-idrequest}")
		@ResponseBody
		 public Loan getbyidrequest(@PathVariable("loan-idrequest")String  idrequest) {
		 return loanservice.getbyidrequest(idrequest);
		 }

		 //http://localhost:8089/SpringMVC/servlet/add-loan
		@PostMapping("/add-loan")
		@ResponseBody
		public Loan addLoan(@RequestBody Loan L) {
			Loan Loan = loanservice.addLoan(L);
		 return Loan;
		 }
		
		//http://localhost:8089/SpringMVC/servlet/remove-Loan/{loan-idrequest}
		@DeleteMapping("/remove-Loan/{idrequest}")
		@ResponseBody
		public void removeLoan(@PathVariable("idrequest") String idrequest) {
			loanservice.deleteLoan(idrequest);
		 }

		// http://localhost:8089/SpringMVC/servlet/modify-Loan
		@PutMapping("/modify-Loan")
		@ResponseBody
		 public Loan modifyLoan(@RequestBody Loan L) {
		 return loanservice.UpdateLoan(L);
		 }

	}


