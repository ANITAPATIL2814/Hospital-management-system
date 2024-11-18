package com.demo.controller;

import com.demo.entity.Appointment;
import com.demo.exception.AppointmentNotFoundException;
import com.demo.service.AppointmentService;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.bookAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);

    }
    
    @GetMapping("/appointmentbyid/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = appointmentService.viewAppointmentById(appointmentId);
        return ResponseEntity.ok(appointment);
    }
    
    // Endpoint to cancel an appointment
    @DeleteMapping("/cancel/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long appointmentId) {
        try {
            boolean isCancelled = appointmentService.cancelAppointment(appointmentId);
            if (isCancelled) {
                return new ResponseEntity<>("Appointment canceled successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to cancel the appointment.", HttpStatus.BAD_REQUEST);
            }
        } catch (AppointmentNotFoundException e) {
            return new ResponseEntity<>("Appointment not found.", HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint to update an appointment's date/time
    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointmentDateTime(
            @PathVariable Long appointmentId, 
            @RequestBody Appointment appointment) {
        try {
            // Assuming the appointmentDateTime is a String in ISO format (e.g., "2024-11-30T15:30:00")
            String newDateTimeString = appointment.getAppointmentDateTime().toString();  // This is a String
            LocalDateTime newDateTime = LocalDateTime.parse(newDateTimeString, DateTimeFormatter.ISO_DATE_TIME);
            
            // Update the appointment with the new date-time
            Appointment updatedAppointment = appointmentService.updateAppointmentDateTime(appointmentId, newDateTime);
            
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } catch (AppointmentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Invalid date-time format
        }
    }

    @GetMapping("/appointmentbypatientid/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentBypatientId(@PathVariable int patientId) throws AppointmentNotFoundException {
        List<Appointment> appointment = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointment);
    }
     

}
