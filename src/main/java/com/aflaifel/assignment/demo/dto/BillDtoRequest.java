package com.aflaifel.assignment.demo.dto;

import java.util.List;

import com.aflaifel.assignment.demo.entity.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDtoRequest {

	long billId;
	
	long userId;

}
