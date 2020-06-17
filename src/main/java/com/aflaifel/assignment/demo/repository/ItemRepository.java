package com.aflaifel.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aflaifel.assignment.demo.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

	ItemEntity findByIdAndDeletedFalse(long itemId);
}
