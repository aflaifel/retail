package com.aflaifel.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aflaifel.assignment.demo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity findByIdAndDeletedFalse(long employeeId);
}
