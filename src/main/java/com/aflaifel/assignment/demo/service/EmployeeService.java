package com.aflaifel.assignment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aflaifel.assignment.demo.entity.EmployeeEntity;
import com.aflaifel.assignment.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;


}
