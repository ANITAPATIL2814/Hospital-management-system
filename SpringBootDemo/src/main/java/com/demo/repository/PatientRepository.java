package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entity.Patient;

//extends JpaRepository for inbuilt method 
public interface PatientRepository  extends JpaRepository<Patient ,Integer >{
	//Custom query - to fetch patient detail based on contact number
	//@Query: Annotation to declare finder queries directly on repository methods.
	 // Custom query - to fetch patient detail based on contact number
	
	
	@Query("SELECT p FROM Patient p WHERE p.contactNumber = :contactNumber")
	Patient findByContactNumber(@Param("contactNumber") String contactNumber);
	
	  // Custom method to fetch a page of patients sorted by a field
    Page<Patient> findAll(Pageable pageable);

	
}
