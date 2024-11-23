package com.demo.serviceimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Patient;
import com.demo.exception.PatientNotFoundException;
import com.demo.repository.PatientRepository;
import com.demo.service.PatientService;

@Service  // Marks the class as a service layer bean
public class PatientServiceImpl implements PatientService {

    @Autowired // Injects the PatientRepository to access data
    private PatientRepository prepo;  // Repository for CRUD operations
    
    @Override
    public Patient registerPatient(Patient patient) {
        // Save the patient record into the database
        return prepo.save(patient); 
    }

    @Override
    public List<Patient> getAllPatients() {
        // Fetch all patient records
        return prepo.findAll();
    }

    @Override
    public Patient getPatientById(int patientId) throws PatientNotFoundException {
        // Fetch patient details by patient ID, throws exception if not found
        return prepo.findById(patientId)
                   .orElseThrow(() -> new PatientNotFoundException("Patient id does not exist, try again with proper patient id "));
    }

    @Override
    public Patient getByPhone(String contactNumber) {
        // Fetch patient details by contact number
        return prepo.findByContactNumber(contactNumber);
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        // Fetch paginated and sorted list of patients
        return prepo.findAll(pageable);
    }
}
