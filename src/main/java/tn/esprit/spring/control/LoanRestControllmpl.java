package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Files;
import tn.esprit.spring.entity.Loan;
import tn.esprit.spring.entity.Loan_Bank;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.Filesservice;
import tn.esprit.spring.service.IMailService;
import tn.esprit.spring.service.LoanService;
import tn.esprit.spring.service.Loan_BankService;
import tn.esprit.spring.service.Loan_ManagementService;
import tn.esprit.spring.service.Loan_logService;
import tn.esprit.spring.service.UserService;

//@CrossOrigin("http://localhost:3306")
@RestController
@EnableAutoConfiguration
@RequestMapping
public class LoanRestControllmpl {
	@Autowired
	LoanService loanservice;
	@Autowired
	UserService userService;
	@Autowired
	IMailService iMailservice;
	@Autowired
	Loan_ManagementService Loan_Managementservice;
	@Autowired
	Loan_BankService  Loan_Bankservice ;
	@Autowired 
	private Filesservice Filesservice;
	@Autowired
	Loan_logService  Loan_logservice;
	// http://localhost:8081/SpringMVC/servlet/get_ALL_Loan
	@GetMapping("/get_ALL_Loan")
	@ResponseBody
	public List<Loan> getALLLoan() {
		List<Loan> list = loanservice.getALLLoan();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/getbyidrequest-loan/{loan-id}
	@GetMapping("/getbyidrequest-loan/{loan-id}")
	@ResponseBody
	public Loan getbyid(@PathVariable("loan-id") String id) {
		return loanservice.getbyid(id);
	}

	// http://localhost:8081/SpringMVC/servlet/add-loan/id
	@PostMapping("/add/{id}")
	@ResponseBody
	public Loan addLoan(@RequestBody Loan L,@PathVariable("id") String id) {
		Loan Loan = loanservice.addLoan(L ,id);
		return Loan;
	}
	@GetMapping("/calculamount/{id}")
	@ResponseBody
	public void calculamount(@RequestBody Loan L,@PathVariable("id") String idrequest ,double amount){
	
	Loan_Bankservice.calculamount( idrequest , amount);
	}
	// http://localhost:8081/SpringMVC/servlet/remove-Loan/{loan-idrequest}
	@DeleteMapping("/remove-Loan/{idrequest}")
	@ResponseBody
	public void removeLoan(@PathVariable("idrequest") String idrequest) {
		loanservice.deleteLoan(idrequest);
	}

	// http://localhost:8081/SpringMVC/servlet/modify-Loan
	@PutMapping("/modify-Loan")
	@ResponseBody
	public Loan modifyLoan(@RequestBody Loan L) {
		return loanservice.UpdateLoan(L);
	}

	@PostMapping("/alert/{id}")
	@ResponseBody
	public void alert(@PathVariable("id") String id) {
		User user = userService.getbyidUser(id);
		iMailservice.sendSimpleMail(user.getEmail()," Alert", "Please Verify your payement  ");
	}
	
	@GetMapping("/")
	@ResponseBody
	public String get(Model model) {
		List<Files> files = Filesservice.getFiles();
		model.addAttribute("files", files);
		return "files";
	}
	
	@PostMapping("/uploadFiles")
	@ResponseBody
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			Filesservice.saveFile(file);
			
		}
		return "redirect:/";
	}
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		Files doc = Filesservice.getFile(fileId).get();
		return ResponseEntity.ok()
				
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFileName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
}

