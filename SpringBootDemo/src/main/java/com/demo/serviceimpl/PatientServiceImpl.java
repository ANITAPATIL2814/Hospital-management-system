package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Patient;
import com.demo.exception.PatientNotFoundException;
import com.demo.repository.PatientRepository;
import com.demo.service.PatientService;

//logic of PatientService CRUD()
@Service  //to mark class as service class
public class PatientServiceImpl implements PatientService {
	@Autowired //to get all method like getter, setter ....
	PatientRepository prepo;//get all methods of repository  
	
	@Override
	public Patient registerPatient(Patient patient) {
		//save() used for inserting new record in table
		return prepo.save(patient); //instead of writing multiple number of code we only write method
	}

	@Override
	public List<Patient> getAllPatients() {
		return prepo.findAll(); //findAll() used to fetch details from table
	}

	@Override
	public Patient getPatientById(int patientId) throws PatientNotFoundException {
		//findById() used to fetch details from table based on id mentioned  or return null if id not available
		return prepo.findById(patientId).orElseThrow(()->(new PatientNotFoundException("Patient does not exist ")));
	}

	@Override
	public Patient getByPhone(String contactNumber) {
		return prepo.findByContactNumber(contactNumber);
	}

}
