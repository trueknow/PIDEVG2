package tn.esprit.spring.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.entity.ProfileEnum;
import tn.esprit.spring.repository.UserRepository;

@Service
public class DAOUserServiceImpl implements DAOUserService{


//	@Autowired
//	private PasswordEncoder bcryptEncoder;
	@Autowired
	UserRepository userRepository ;

	private static final Logger L = LogManager.getLogger(DAOUserServiceImpl.class);

	@Override
	public List<DAOUser> getAllUsers(){

		List<DAOUser> users = (List<DAOUser>) userRepository.findAll();
		for(DAOUser user : users)
			L.info("user +++ : " + user);

		return users;

	}

	
	@Override
	public DAOUser getbyidUser(String id){
		L.info("in retrieveUser id = " + id);
		
		DAOUser u = userRepository.findById(Long.parseLong(id)).orElse(null);
		
		L.info("user returned :" + u);
		return u ;

	}
	@Override
	public DAOUser createUser(DAOUser u){

		DAOUser userSaved = null ;
		
//		u.setPassword(bcryptEncoder.encode(u.getPassword()));
		u.setProfile(ProfileEnum.ROLE_CLIENT);
		userSaved = userRepository.save(u);
		return userSaved;
	}
	@Override
	public DAOUser updateUser(DAOUser u){

		return userRepository.save(u);
	}
	
	@Override
	public void deleteUser(String id){
		
		userRepository.deleteById(Long.parseLong(id));
	}
	@Transactional
	@Override
	public void updateUserProfile(DAOUser u){

		 userRepository.setProfileForDAOUser(u.getProfile(), u.getId());
	}
	
	@Override
	public List<DAOUser> findByNames(String name){
		
		
		List<DAOUser> users = (List<DAOUser>) userRepository.findByName(name);
		for(DAOUser user : users)
			L.info("user +++ : " + user);

		return users;
		
	}
	
	@Override
	public void activateclient(String id){
		DAOUser user = userRepository.findById(Long.parseLong(id)).orElse(null);
		user.setIsActive(true);
		userRepository.save(user);
	}

}
