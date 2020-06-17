package com.aflaifel.assignment.demo.entity;

import java.time.LocalDateTime;
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
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@NotNull
	private String name;
	
	@NotNull
	private LocalDateTime joinDate;
	
	private boolean isEmployee;
	
	private boolean isAffiliate;
	
	private boolean deleted;
	

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "user")
	private List<BillEntity> bills;
}
