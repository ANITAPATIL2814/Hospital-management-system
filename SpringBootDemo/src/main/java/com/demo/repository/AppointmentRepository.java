package com.demo.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	// Custom query using JPQL to fetch appointments by patientId
    @Query("SELECT a FROM Appointment a WHERE a.patient.patientId = :patientId")
    List<Appointment> findAppointmentsByPatientId(int patientId);
    
 // Custom method to fetch a page of appointment sorted by a field
    Page<Appointment> findAll(Pageable pageable);
}
