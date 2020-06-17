package com.aflaifel.assignment.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private float price;
	
	@NotNull
	private String type;  //could be enum in the future

	private boolean deleted;
	
}
