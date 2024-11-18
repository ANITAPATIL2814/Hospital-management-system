package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entity.Patient;
import com.demo.exception.PatientNotFoundException;
import com.demo.service.PatientService;
import jakarta.validation.Valid;


@RestController // convenience annotation that is itself annotated with @Controller and @ResponseBody. 
public class PatientController {
	
	@Autowired //Marks a constructor, field, setter method
	PatientService ps;
	
	//@valid - to check validation while data insertion
	//@RequestBody : body to http request 
	//post mapping : insert patient details with httpstatus created and httpstatuscode 201
	@PostMapping("/registerPatient")
	public ResponseEntity<Patient> registerPatient(@Valid @RequestBody Patient patient){
		return new ResponseEntity<>(ps.registerPatient(patient),HttpStatusCode.valueOf(201)); //201 is post status code
		
	}
	@GetMapping("/allPatients")
	public List<Patient> fetchPatient(){
		return ps.getAllPatients();
	}
	
	
	@GetMapping("/Patientsbyid/{patientId}")
	public ResponseEntity<Patient> fetchPatientById(@PathVariable int patientId) throws PatientNotFoundException
	{
		return new ResponseEntity<Patient>(ps.getPatientById(patientId),HttpStatusCode.valueOf(200));
	}
	
	
	@GetMapping("/Patientsbyphone/{contactNumber}") // Ensure case matches
	public ResponseEntity<Patient> fetchPatientbycontactnumber(@PathVariable("contactNumber") String contactNumber) {
	    return new ResponseEntity<Patient>(ps.getByPhone(contactNumber), HttpStatusCode.valueOf(200));
	}

	
	
}
