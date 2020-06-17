package com.aflaifel.assignment.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	private boolean deleted;
	
	float totalAmount;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "bill")
	private List<BillItemEntity> items;
}
