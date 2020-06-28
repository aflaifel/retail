package com.aflaifel.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aflaifel.assignment.demo.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByIdAndDeletedFalse(long userId);
	UserEntity findByNameAndDeletedFalse(String name);
}
