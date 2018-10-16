package com.annotationDemo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.model.UserDTO;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class RegistrationDAOTest {

@InjectMocks
RegistrationDAO registrationDAO;

@Mock
EntityManager entityManager;

@Mock
UserDTO userDTO;

@Test
public void shouldRegisterUserMethodRegisterUserDTO(){
	doNothing().when(entityManager).persist(userDTO);;
	registrationDAO.addUser(userDTO);
	verify(entityManager).persist(userDTO);
}

}
