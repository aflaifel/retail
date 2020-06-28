package com.aflaifel.assignment.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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



@RunWith(SpringRunner.class)
public class TestUserService {
	
	static Logger logger = LoggerFactory.getLogger(TestUserService.class);

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Before
	public void setup() {		
//		UserEntity user =  UserEntity.builder().name("Abdallah").isEmployee(true).build();
		when(userRepository.findByNameAndDeletedFalse("Abdallah").getName()).thenReturn("Abdallah");
	}
	
	
	
	@Test
    public void initializationTest() {
        //region Not Null Object Assertions
		logger.info("inside initializationTest()");
        Assert.assertNotNull("userService should not be null", userService);
    }
	
	
	/*
	 * @Test public void isEmployeeAndUserDosentExist_shouldThrowException() throws
	 * Exception {
	 * 
	 * String name = "Abdallah";
	 * 
	 * boolean isEmp = userService.isEmployee(name);
	 * 
	 * assertEquals("assuming that user is employee", isEmp, true);
	 * 
	 * }
	 */
	
}
