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
import com.demo.validation.ValidPhoneNumber;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int doctorId;

  //@Column : used for properties - unique , null , or what else we what for that purpose we use this
  	@Column(length = 25, nullable = false) //  by default true
  	@NotBlank(message="doctor name is mandatory")//to ensure char given in firstname
  	@Size(min=3,message="doctor name must be 3 or more character ") //minimum 2 char given in firstname
    private String firstName;

    @Column(length = 50, nullable = false)
	@Size(min=3,message="doctor surname must be 3 or more character ") //minimum 2 char given in firstname
	private String lastName;

    @NotBlank(message="Doctor email is mandatory")//to ensure char given in emailID
	@Email(message="Doctor email is improper, enter proper email")
	@Column(length = 20, nullable = false, unique=true) 
	private String DoctorEmailID;
    
    @Column(length = 100)
    private String specialty;  // For example, "Cardiologist", "Pediatrician", etc.

    @Column(length = 15)
    @ValidPhoneNumber(message="10 digit is mandatory ")
    private String contactNumber;  // Doctor's contact number

    
}
