package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.service.ITransactionService;


@Controller
public class TransactionRestControlImpl {

	@Autowired
	private ITransactionService transactionService;

	// http://localhost:8081/SpringMVC/servlet/Transactions
	@RequestMapping("/Transactions")
	@ResponseBody
	public String index(Model model) {
		return "accounts";
	}
	// http://localhost:8081/SpringMVC/servlet//Transaction/Deposit/{accountId}/{amount}
	@PostMapping("/Transaction/Deposit/{accountId}/{amount}")
	@ResponseBody
	public void payToAccount(@RequestParam("accountId") String accountId, 
			@RequestParam("amount") double amount) throws RuntimeException
	{
		transactionService.payToAccount(accountId, amount);
	}

	// http://localhost:8081/SpringMVC/servlet//Transaction/Withrawal/{accountId}/{amount}
	@PostMapping("/Transaction/Withrawal/{accountId}/{amount}")
	@ResponseBody
	public void removeFromAccount(@RequestParam("accountId") String accountId, 
			@RequestParam("amount") double amount) throws RuntimeException
	{
		transactionService.removeFromAccount(accountId, amount);
	}

	// http://localhost:8081/SpringMVC/servlet/bankaccount/transfer/{accountId}/{accountIdDest}/{amount}
	@GetMapping("/Transaction/transfer/{accountId}/{accountIdDest}/{amount}")
	@ResponseBody
	public void transfer(@RequestParam("accountId") String accountId, 
			@RequestParam("accountIdDest") String accountIdDest,
			@RequestParam("amount") double amount) throws RuntimeException
	{
		transactionService.transfer(accountId, accountIdDest, amount);
	}

	// http://localhost:8081/SpringMVC/servlet/saveAccountTransaction
	@RequestMapping(value = "/saveAccountTransaction", method = RequestMethod.POST)
	public String saveAccountTransaction(Model model, String accountId, String operationType, String accountIdDest,
			@RequestParam(defaultValue = "0") double amount) {
		try {
			if (operationType.equals("DEPOSIT")) {
				transactionService.payToAccount(accountId, amount);
			} else if (operationType.equals("WITHDRAWAL")) {
				transactionService.removeFromAccount(accountId, amount);
			} else {
				transactionService.transfer(accountId, accountIdDest, amount);
			}
		} catch (Exception e) {
			String message=e.getMessage();
			if (message.equals("No value present")) {
				message="impossible to make the transfer because ,the account "+accountIdDest+" does not exist in our data base ";
			}

			model.addAttribute("errorModel", message);
			return "redirect:/getAccount?accountId=" + accountId + "&errorModel=" + message;
		}

		return "redirect:/getAccount?accountId=" + accountId;
	}

}

