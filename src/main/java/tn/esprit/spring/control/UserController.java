package tn.esprit.spring.control;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.entity.ProfileEnum;
import tn.esprit.spring.service.DAOUserService;


@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC
@ELBeanName(value = "userController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class UserController {
	
	
	@Autowired
	DAOUserService userService;
	private String name;
	private String prename;
    private String email;
	 private  String password;
	private  Boolean isActive ;
	private  ProfileEnum profile;
	private Boolean loggedIn;
	 private DAOUser authenticatedUser;
	 private DAOUser user;
	
	
	
	
	
	public DAOUser getUser() {
		return user;
	}
	public void setUser(DAOUser user) {
		this.user = user;
	}
	public DAOUser getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(DAOUser authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

		 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrename() {
		return prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public ProfileEnum getProfile() {
		return profile;
	}
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	
	public String doLogin() {
		String navigateTo = "null";
		DAOUser u=userService.authenticate(email, password);
		if (u != null && u.getProfile() == ProfileEnum.ROLE_ADMIN) {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
		
		


}
