package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class LabTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // for auto increment 
	private Long  LabId;
	
	@Column(length = 30, nullable = false) //  by default true
	@NotBlank(message="Test name is mandatory")//to ensure char given in testname
	private String testName;
	
	@Column(length = 50)
	private String description;
	
	@Column(length = 8, nullable = false)
	@NotNull(message="test price is missing ")
	private double price;
}
