package com.aflaifel.assignment.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aflaifel.assignment.demo.entity.UserEntity;
import com.aflaifel.assignment.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
   UserRepository userRepository;
	
	//Exception will be changed to meaningful exception
	public  boolean isEmployee(long userId) throws Exception  {
		try {
		Optional<UserEntity> user =  userRepository.findById(userId);
		if(user != null)
		return  user.get().isEmployee();
		else
			throw new Exception();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  boolean isEmployee(String username) throws Exception  {
		try {
		UserEntity user =  userRepository.findByNameAndDeletedFalse(username);
		if(user != null)
		return  user.isEmployee();
		else
			throw new Exception();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public  boolean isAffiliate(long userId) throws Exception  {
		UserEntity user =  userRepository.findByIdAndDeletedFalse(userId);
		if(user != null)
		return  user.isAffiliate();
		else
			throw new Exception();
	}
	
	public  boolean isLoyalUser(long userId) throws Exception  {
		UserEntity user =  userRepository.findByIdAndDeletedFalse(userId);
		if(user != null) {
			Period period = Period.between(user.getJoinDate().toLocalDate(), LocalDate.now());
		return  period.getYears() >= 2;
		}
		else
			throw new Exception();
	}
	
}
