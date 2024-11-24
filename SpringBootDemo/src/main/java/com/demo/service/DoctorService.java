package com.demo.service;

import java.util.List;
import com.demo.entity.Doctor;
import com.demo.exception.DoctorNotFoundException;

public interface DoctorService {
	
	 public Doctor getDoctor(int doctorId) throws DoctorNotFoundException;

	 public List<Doctor> getAllDoctors() ;
}
