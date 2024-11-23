package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.demo.entity.Patient;
import com.demo.exception.PatientNotFoundException;

//CRUD declaration for patient entity
public interface PatientService {
	
	//save patient details
	Patient registerPatient(Patient patient );
	
	//fetch all patient details
	List<Patient> getAllPatients();
	
	//fetch patient detail using patientId
	Patient getPatientById(int patientId) throws PatientNotFoundException;
	
	//fetch patient details using contact number 
	Patient getByPhone(String contactNumber);
	
	  // Fetch patients with pagination and sorting
    Page<Patient> getPatients(Pageable pageable);

}
