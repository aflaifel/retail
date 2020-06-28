package com.aflaifel.assignment.demo.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import com.aflaifel.assignment.demo.entity.UserEntity;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestUserRepository {

	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void whenFindById_thenReturnBill() {
		String name = "Abdallah";
		UserEntity user = UserEntity.builder().name(name).build();
		
		UserEntity foundUser = userRepository.findByNameAndDeletedFalse(name);
		
		assertEquals("the return bill should be the same as the saved one", user.getName(), foundUser.getName());
		
	}
}
