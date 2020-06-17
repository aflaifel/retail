package com.aflaifel.assignment.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bill_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	ItemEntity item;
	
	@ManyToOne
	@JoinColumn(name="bill_id")
	@JsonBackReference
	BillEntity bill;
}
