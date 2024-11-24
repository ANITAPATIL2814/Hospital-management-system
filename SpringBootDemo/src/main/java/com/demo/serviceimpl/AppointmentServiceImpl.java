package com.demo.serviceimpl;

import com.demo.entity.Appointment;
import com.demo.exception.AppointmentNotFoundException;
import com.demo.repository.AppointmentRepository;
import com.demo.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        // Logic to save the appointment (ensure you fetch and set the Patient and LabTest entities if needed)
        return appointmentRepository.save(appointment);
    }
    
    @Override
    public Appointment viewAppointmentById(Long appointmentId) throws AppointmentNotFoundException {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId));
    }

    @Override
    public boolean cancelAppointment(Long appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId));
        
        // Optionally, set the appointmentDateTime to null or another specific date if needed
        appointment.setAppointmentDateTime(null);  // Assuming null means canceled
        
        // Save the updated appointment
        appointmentRepository.save(appointment);

        return true;
    }

    @Override
    public Appointment updateAppointmentDateTime(Long appointmentId, LocalDateTime newDateTime) throws AppointmentNotFoundException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId));

        // Update the appointment's date/time
        appointment.setAppointmentDateTime(newDateTime);
        
        // Save the updated appointment
        return appointmentRepository.save(appointment);
    }

	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {
		 return appointmentRepository.findAppointmentsByPatientId(patientId);
	}

	@Override
	public Page<Appointment> getAppointment(Pageable pageable) {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll(pageable);
	}


	
}
