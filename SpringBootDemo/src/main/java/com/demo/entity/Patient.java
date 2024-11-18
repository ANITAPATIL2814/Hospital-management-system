package com.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//@ means annotation
@Entity
@Getter //generate all get methods 
@Setter  //generate all set  methods
public class Patient {
	
	@Id //to generate and create a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // for auto increment 
	private int  patientId; //primary key
	
	//@Column : used for properties - unique , null , or what else we what for that purpose we use this
	@Column(length = 25, nullable = false) //  by default true
	@NotBlank(message="Patient name is mandatory")//to ensure char given in firstname
	@Size(min=3,message="patient name must be 3 or more character ") //minimum 2 char given in firstname
	private String firstName;
	
	
	
	@Column(length = 35) 
	@Size(min=3,message="patient surname must be 3 or more character ") //minimum 2 char given in firstname
	private String lastName;
	
	@NotBlank(message="patient DOB is mandatory")//to ensure char given in dateofbirth
	@Column(length = 10, nullable = false) 
	private String dateofbirth;
	
	@NotBlank(message="patient contact Number is mandatory")//to ensure char given in contactNumber
	@Column(length = 11, nullable = false, unique=true) 
	private String contactNumber;
	
	@NotBlank(message="patient email is mandatory")//to ensure char given in emailID
	@Email(message="patient email is improper, enter proper email")
	@Column(length = 20, nullable = false, unique=true) 
	private String emailID;
	
	@NotBlank(message="patient address is mandatory")//to ensure char given in address
	@Column(length = 50, nullable = false) 
	private String address;
	
	@Column(length = 5) 
	private String boodGroup ;
	
	private int weight;
	private int height;
}
