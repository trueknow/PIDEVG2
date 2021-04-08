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

import tn.esprit.spring.entity.Account;
import tn.esprit.spring.service.IAccountService;

@RestController
public class AccountRestControlImpl {

 @Autowired
 IAccountService accountService;


 // http://localhost:8081/SpringMVC/servlet/retrieve-all-accounts
 @GetMapping("/retrieve-all-accounts")
 @ResponseBody
 public List<Account> getAccounts() {
 List<Account> list = accountService.retrieveAllAccounts();
 return list;
 }
//http://localhost:8081/SpringMVC/servlet/retrieve-account/{account-accountId}
 @GetMapping("/retrieve-account/{account-accountId}")
 @ResponseBody
 public Account retrieveAccount(@PathVariable("account-accountId") String accountId) {
 return accountService.retrieveAccount(accountId);
 }

 //Ajouter Account : http://localhost:8081/SpringMVC/servlet/add-account
 @PostMapping("/add-account")
 @ResponseBody
 public Account addAccount(@RequestBody Account a) {
 Account account = accountService.addAccount(a);
 return account;
 }
//http://localhost:8081/SpringMVC/servlet/remove-account/{account-accountId}
 @DeleteMapping("/remove-account/{account-accountId}")
 @ResponseBody
 public void removeAccount(@PathVariable("account-accountId") String accountId) {
 accountService.deleteAccount(accountId);
 }

// http://localhost:8081/SpringMVC/servlet/modify-account
 @PutMapping("/modify-account")
 @ResponseBody
 public Account modifyAccount(@RequestBody Account account) {
 return accountService.updateAccount(account);
 }
}
