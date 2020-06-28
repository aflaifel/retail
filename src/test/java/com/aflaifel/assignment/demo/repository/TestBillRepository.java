package com.aflaifel.assignment.demo.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.aflaifel.assignment.demo.entity.BillEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestBillRepository {

	@Autowired
	BillRepository billRepository;

	@Test
	@Transactional
	@Rollback(true)
	public void whenFindById_thenReturnBill() {
		int id = 999;
		BillEntity bill = BillEntity.builder().id(id).build();
		
		BillEntity foundBill = billRepository.findByIdAndDeletedFalse(id);
		
		assertEquals("the return bill should be the same as the saved one", bill.getId(), foundBill.getId());
		
	}
}
