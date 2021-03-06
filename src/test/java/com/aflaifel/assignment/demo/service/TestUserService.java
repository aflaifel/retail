package com.aflaifel.assignment.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.aflaifel.assignment.demo.entity.UserEntity;
import com.aflaifel.assignment.demo.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

//	static Logger logger = LoggerFactory.getLogger(TestUserService.class);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

//	@Mock
//	UserRepository userRepository;

	@InjectMocks
	UserService userService;

	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this); // userService = new UserService();
		// userRepository = mock(UserRepository.class); //
		// when(userRepository.findByNameAndDeletedFalse("Abdallah").getName()).
//	  thenReturn(null); 
	}

	@Test
	public void initializationTest() {
//		logger.info("inside initializationTest()");
		Assert.assertNotNull("userService should not be null", userService);
	}

//	@Test 
//	public void isEmployeeAndUserDosentExist_shouldThrowException() throws
//	  Exception {
//	  
//	  String name = "Abdallah";
//	  
//	  boolean isEmp = userService.isEmployee(name);
//	  
//	  thrown.expect(Exception.class);
//	  
//	  }

}
