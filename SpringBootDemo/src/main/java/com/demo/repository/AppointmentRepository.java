package com.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	// Custom query using JPQL to fetch appointments by patientId
    @Query("SELECT a FROM Appointment a WHERE a.patient.patientId = :patientId")
    List<Appointment> findAppointmentsByPatientId(int patientId);
    
}
