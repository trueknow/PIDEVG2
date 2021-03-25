package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getbyidUser(String id);
	public User createUser(User u);
	public User updateUser(User u);
	public void deleteUser(String id);

}
