package com.annotationDemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.model.UserDTO;
import com.annotationDemo.repository.LoginDAO;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginService loginservice;
	
	@Mock
	LoginDAO loginDAO;
	
	@Test
	public void shouldValidateUserMethodReturnUserDTO(){
		UserDTO dto = new UserDTO();
		when(loginDAO.validateUser("df", "123")).thenReturn(dto);
		
		Assert.assertEquals(dto, loginservice.validateUser("df", "123"));
		verify(loginDAO).validateUser("df", "123");
	}
}
