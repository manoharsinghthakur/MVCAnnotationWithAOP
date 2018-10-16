package com.annotationDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annotationDemo.model.UserDTO;
import com.annotationDemo.repository.LoginDAO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	public UserDTO validateUser(String email, String password){
		return loginDAO.validateUser(email, password);		
	}
}
