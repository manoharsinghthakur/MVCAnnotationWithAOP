package com.annotationDemo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.annotationDemo.model.UserDTO;

@Repository
@Transactional
public class RegistrationDAO {

	@PersistenceContext
	EntityManager entityManager;

	public Integer addUser(UserDTO dto) {
			entityManager.persist(dto);
			System.out.println("Data Save Successfully !!");
		return dto.getUserId();
	}
}
