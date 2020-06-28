package com.aflaifel.assignment.demo.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aflaifel.assignment.demo.dto.BillDto;
import com.aflaifel.assignment.demo.dto.BillDtoRequest;
import com.aflaifel.assignment.demo.entity.BillEntity;
import com.aflaifel.assignment.demo.entity.BillItemEntity;
import com.aflaifel.assignment.demo.entity.ItemEntity;
import com.aflaifel.assignment.demo.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billRepository;

	@Autowired
	UserService userService;

	private static String discountType;
	private static float discountAmount;

	public BillDto calculateBill(BillDtoRequest bill) throws Exception {
		BillEntity billEntity = billRepository.findById(bill.getBillId()).get();
		if (billEntity != null) {
			if (userService.isEmployee(bill.getUserId())) {
				discountType = "emp";
				discountAmount = 0.3F;
				billEntity = employeeBillCalculater(billEntity);
			} else if (userService.isAffiliate(bill.getUserId())) {
				discountType = "affil";
				discountAmount = 0.1F;
				billEntity = affiliateBillCalculater(billEntity);
			} else if (userService.isLoyalUser(bill.getUserId())) {
				discountType = "loyal";
				discountAmount = 0.05F;
				billEntity = loyalityCustomerBillCalculater(billEntity);
			} else {

				discountType = "100";
				discountAmount = 0.05F;
				oneHandredDiscount(billEntity.getItems());
			}
			//billRepository.save(billEntity);
			return mapEntityToDto(billEntity, discountType, discountAmount);
		}
		else 
			throw new Exception("list not found");
	}

	private static BillEntity employeeBillCalculater(BillEntity bill) throws Exception {
		// it could be configured and read from DB or config file
		float employeeDiscount = 0.3F;
		String illegibleType = "grocery";
		bill = calculateDiscount(bill, employeeDiscount, illegibleType);
		return bill;
	}

	private static BillEntity affiliateBillCalculater(BillEntity bill) {
		float affiliateDiscount = 0.1F;
		String illegibleType = "grocery";
		bill = calculateDiscount(bill, affiliateDiscount, illegibleType);
		return bill;
	}

	private static BillEntity loyalityCustomerBillCalculater(BillEntity bill) {
		float towYearsDiscount = 0.05F;
		String illegibleType = "grocery";
		bill = calculateDiscount(bill, towYearsDiscount, illegibleType);
		return bill;
	}

	private static float oneHandredDiscount(List<BillItemEntity> list) {
		int discountAmount = 5;
		float totalAmount = (float) list.stream().mapToDouble(i -> i.getItem().getPrice()).sum();
		int totaldiscount = discountAmount * (int) totalAmount / 100;
		return totalAmount - totaldiscount;
	}

	private static BillEntity calculateDiscount(BillEntity items, float discount,
			String illegibleType) {
		items.getItems().stream()
		.filter(item -> !illegibleType.equals(item.getItem().getType())).collect(Collectors.toList())
		.forEach(item -> item.getItem()
				.setPrice(item.getItem().getPrice() - (item.getItem().getPrice() * discount)));
		return items;
	}

	private static BillDto mapEntityToDto(BillEntity billEntity, String discountType, float discountAmount) {
		BillDto billDto = new BillDto();
		billDto.setBillId(billEntity.getId());
		DecimalFormat df = new DecimalFormat("##");
		billDto.setDiscount(df.format(discountAmount*100)+ "%");
		billDto.setDiscountType(discountType);
		billDto.setTotal((float) billEntity.getItems().stream().mapToDouble(i -> i.getItem().getPrice()).sum());
		List<ItemEntity> items = new ArrayList<>();
		List<BillItemEntity> list = billEntity.getItems();
		for(BillItemEntity item: list)
			items.add(item.getItem());
		billDto.setItems(items);
		return billDto;

	}

}
