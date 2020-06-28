package com.aflaifel.assignment.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.aflaifel.assignment.demo.entity.BillEntity;
import com.aflaifel.assignment.demo.entity.BillItemEntity;
import com.aflaifel.assignment.demo.entity.UserEntity;
import com.aflaifel.assignment.demo.repository.BillRepository;
import com.aflaifel.assignment.demo.service.BillService;

//@RunWith(MockitoJUnitRunner.class)
public class TestBillService {
	
//	@InjectMocks
	BillService billService;
	
//	@Mock
	BillRepository billRepository;

//	@Test
	public void testGetAllBills_Success() {
		List<BillEntity> bills = new ArrayList<BillEntity>();
		List<BillItemEntity> itemList = new ArrayList<BillItemEntity>();
		bills.add(new BillEntity(1, new UserEntity(), false, 150, itemList)); 
		bills.add(new BillEntity(2, new UserEntity(), false, 140, itemList));
		bills.add(new BillEntity(3, new UserEntity(), false, 130, itemList));
	
		when(billRepository.findAll()).thenReturn(bills);
		
		List<BillEntity> billList = billRepository.findAll();
		
		assertEquals(3, billList.size());
	}
    
//	@Test
	public void testGetAllBills_Failed() {
		List<BillEntity> bills = new ArrayList<BillEntity>();
	
		when(billRepository.findAll()).thenReturn(bills);
		
		List<BillEntity> billList = billRepository.findAll();
		
		assertEquals(0, billList.size());
	}
	
	
//	@Test
	public void whenSaveList_getAllBills_shouldReturnSameList() {
		List<BillEntity> bills = new ArrayList<BillEntity>();
		
	}
}
