package com.demo.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Doctor;
import com.demo.exception.DoctorNotFoundException;
import com.demo.repository.DoctorRepository;
import com.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
    private DoctorRepository doctorRepository;
	
	@Override
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException("Entered doctor id not proper"));
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

}
