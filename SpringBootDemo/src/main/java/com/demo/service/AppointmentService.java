package com.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.demo.entity.Appointment;
import com.demo.exception.AppointmentNotFoundException;

public interface AppointmentService {
	
    Appointment bookAppointment(Appointment appointment);
    
    Appointment viewAppointmentById(Long appointmentId) throws AppointmentNotFoundException;

    // Method to cancel an appointment
    boolean cancelAppointment(Long appointmentId) throws AppointmentNotFoundException;

 // Method to update an appointment's date/time
    Appointment updateAppointmentDateTime(Long appointmentId, LocalDateTime newDateTime) throws AppointmentNotFoundException;
    
    public List<Appointment> getAppointmentsByPatientId(int patientId);
    
    // Fetch Appointment with pagination and sorting
    Page<Appointment> getAppointment(Pageable pageable);
}

