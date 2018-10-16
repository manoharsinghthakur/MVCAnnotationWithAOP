package com.annotationDemo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.model.UserDTO;

import junit.framework.Assert;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LoginDAOTest {

	@InjectMocks
	LoginDAO loginDAO;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	Query query;
	
	@Test
	public void shouldValidateMethodReturnUserDTOList(){
		String userName = "ms";
		String password = "123";
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(11);
		userDTO.setUserName("ms");
		userDTO.setPassword("123");
		List<UserDTO> userList = new ArrayList<UserDTO>();
		userList.add(userDTO);
		
		when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		when(query.getResultList()).thenReturn(userList);
		
		Assert.assertNotNull(loginDAO.validateUser(userName, password));
		
		verify(entityManager).createQuery(Mockito.anyString());
		verify(query).getResultList();
	}

	
	@Test
	public void shouldValidateMethodReturnNull(){
	
		List<UserDTO> userList = new ArrayList<UserDTO>();
		when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		when(query.getResultList()).thenReturn(userList);
		
		Assert.assertNull(loginDAO.validateUser("fd","12" ));
		verify(entityManager).createQuery(Mockito.anyString());
		verify(query).getResultList();
	}
}
