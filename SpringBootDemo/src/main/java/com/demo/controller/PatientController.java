package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.entity.Patient;
import com.demo.exception.PatientNotFoundException;
import com.demo.service.PatientService;
import jakarta.validation.Valid;

@RestController
public class PatientController {

    @Autowired
    private PatientService ps;

    @PostMapping("/registerPatient")
    public ResponseEntity<Patient> registerPatient(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(ps.registerPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/allPatients")
    public List<Patient> fetchAllPatients() {
        return ps.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> fetchPatientById(@PathVariable int patientId) throws PatientNotFoundException {
        return new ResponseEntity<>(ps.getPatientById(patientId), HttpStatus.OK);
    }

    @GetMapping("/byPhone/{contactNumber}")
    public ResponseEntity<Patient> fetchPatientByContactNumber(@PathVariable String contactNumber) {
        return new ResponseEntity<>(ps.getByPhone(contactNumber), HttpStatus.OK);
    }

    // Endpoint to get paginated and sorted patients
    @GetMapping("/paged")
    public Page<Patient> getPagedPatients(
            @RequestParam(defaultValue = "0") int page,  // Page number (default 0)
            @RequestParam(defaultValue = "10") int size) { // Number of records per page (default 10)

        // Create the Sort object to sort by 'firstName' in ascending order
        Sort sort = Sort.by(Sort.Order.asc("firstName"));

        // Create Pageable object with sorting by 'firstName'
        PageRequest pageable = PageRequest.of(page, size, sort);

        // Fetch the patients with pagination and sorting
        return ps.getPatients(pageable);
    }

}
