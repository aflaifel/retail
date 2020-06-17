package com.aflaifel.assignment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aflaifel.assignment.demo.dto.BillDto;
import com.aflaifel.assignment.demo.dto.BillDtoRequest;
import com.aflaifel.assignment.demo.entity.BillEntity;
import com.aflaifel.assignment.demo.service.BillService;


@RestController
public class BillController {

	@Autowired
	BillService billService;
	
	@PostMapping("/bill")
	public BillDto calculateBill(@RequestBody BillDtoRequest bill){
		try {
			return billService.calculateBill(bill);
		} catch (Exception e) {
			// we can throw our own exception with the proper status code or handle it using RestAdvisor 
			e.printStackTrace();
		}
		return null;
	}
}