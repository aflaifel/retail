package com.aflaifel.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aflaifel.assignment.demo.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

	BillEntity findByIdAndDeletedFalse(long billId);
}
