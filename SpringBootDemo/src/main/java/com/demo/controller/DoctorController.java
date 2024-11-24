package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Doctor;
import com.demo.exception.DoctorNotFoundException;
import com.demo.service.DoctorService;

@RestController
public class DoctorController {
	
	 @Autowired
	    private DoctorService doctorService;
	
	// Get a Doctor by ID
    @GetMapping("/DoctorId/{doctorId}")
    public Doctor getDoctor(@PathVariable int doctorId) throws DoctorNotFoundException {
        return doctorService.getDoctor(doctorId);
    }

    // Get all doctors
    @GetMapping("/AllDoctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
