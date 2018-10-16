package com.annotationDemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annotationDemo.model.UserDTO;
import com.annotationDemo.repository.RegistrationDAO;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Transactional
	public Integer addUser(UserDTO userDTO) {
		return registrationDAO.addUser(userDTO);
	}
}
