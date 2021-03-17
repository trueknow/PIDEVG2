package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.UserRepository;

@Service
public class UserService {

@Autowired	
	private UserRepository userrepository;
	
}
