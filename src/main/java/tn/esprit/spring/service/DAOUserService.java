package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.DAOUser;

public interface DAOUserService {
	
	public List<DAOUser> getAllUsers();
	public DAOUser getbyidUser(String id);
	public DAOUser createUser(DAOUser u);
	public DAOUser updateUser(DAOUser u);
	public void deleteUser(String id);
	public void updateUserProfile(DAOUser u);
	public List<DAOUser> findByNames(String name);
	public void activateclient(String id);
	public DAOUser authenticate(String login, String password) ;
	public Long addOrUpdateUser(DAOUser user);
}
