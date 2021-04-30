package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.DAOUserService;
import tn.esprit.spring.service.IMailService;

@RestController
public class UserRestControlImpl {

	@Autowired
	IMailService mai;
	@Autowired
	DAOUserService userService;
	@Autowired
	UserRepository repo;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<DAOUser> getUsers() {
		List<DAOUser> list = userService.getAllUsers();
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-user/{user-id}
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public DAOUser  retrieveUser(@PathVariable("user-id") String userId) {
		return userService.getbyidUser(userId);
	}

	// Ajouter User : http://localhost:8080/SpringMVC/servlet/add-user
	@PostMapping("/register-user")
	@ResponseBody
	public DAOUser addUser(@RequestBody DAOUser u) {
		DAOUser user = userService.createUser(u);
		mai.sendSimpleMail(u.getEmail(),"Verification","You're account have been created. Wait for the admin to activate your account.Thank you!");
		return user;
	}

	// http://localhost:8080/SpringMVC/servlet/remove-user/{user-id}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") String userId) {
		userService.deleteUser(userId);
	}

	// http://localhost:8080/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user")
	@ResponseBody
	public DAOUser modifyUser(@RequestBody DAOUser user) {
		return userService.updateUser(user);
	}
//	@PutMapping("/modify-client-name-prename")
//	@ResponseBody
//	public DAOUser modifyUserclient(@RequestBody DAOUser user) {
////		UserDetails userDetails = (UserDetails) SecurityContextHolder. getContext(). getAuthentication()
////				. getPrincipal();
//				String username = userDetails. getUsername();
//				DAOUser client = repo.findByemail(username);
//				user.setId(client.getId());
//				user.setPassword(client.getPassword());
//				user.setEmail(client.getEmail());
//				user.setIsActive(client.getIsActive());
//				user.setProfile(client.getProfile());
//		return userService.updateUser(user);
//	}
//	@PutMapping("/modify-client-email")
//	@ResponseBody
//	public DAOUser modifyUserclientemail(@RequestBody DAOUser user) {
//		UserDetails userDetails = (UserDetails) SecurityContextHolder. getContext(). getAuthentication()
//				. getPrincipal();
//				String username = userDetails. getUsername();
//				DAOUser client = repo.findByemail(username);
//				user.setId(client.getId());
//				user.setPassword(client.getPassword());
//				user.setName(client.getName());
//				user.setPrename(client.getPrename());
//				user.setIsActive(client.getIsActive());
//				user.setProfile(client.getProfile());
//		return userService.updateUser(user);
//	}
	// http://localhost:8080/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user-role")
	@ResponseBody
	public void modifyUserRole(@RequestBody DAOUser user) {
		 userService.updateUserProfile(user);
	}
	@GetMapping("/getbyname/{name}")
	@ResponseBody
	public List<DAOUser>  retrieveUserbyName(@PathVariable("name") String name) {
		return userService.findByNames(name);
	} 


	@PostMapping("/sendverif/{id}")
	@ResponseBody
	public void sendverif(@PathVariable("id")String id){
		DAOUser user = userService.getbyidUser(id);
		user.setIsActive(true);
		repo.save(user);
		mai.sendSimpleMail(user.getEmail(),"Account activation","You're account have been activated.Thank you for your patience.");
	}
}