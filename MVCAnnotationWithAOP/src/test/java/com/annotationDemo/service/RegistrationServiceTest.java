package com.annotationDemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.model.UserDTO;
import com.annotationDemo.repository.RegistrationDAO;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
	
	@InjectMocks
	RegistrationService registrationService;
	
	@Mock
	RegistrationDAO registrationDAO;

	@Test
	public void shouldAddUserMethodReturnUserId(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(5);
		
		when(registrationDAO.addUser(userDTO)).thenReturn(userDTO.getUserId());
		
		Integer userId = registrationService.addUser(userDTO);
		
		verify(registrationDAO).addUser(userDTO);
		Assert.assertEquals(userDTO.getUserId(), userId);
	}
}
