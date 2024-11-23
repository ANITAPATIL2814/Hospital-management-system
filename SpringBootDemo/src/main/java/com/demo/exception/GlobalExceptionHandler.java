package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Handles PatientNotFoundException and returns a 404 status with an error message.
	 @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePatientNotFoundException(PatientNotFoundException pe,
            WebRequest request) {
        // Create error message with 404 status code and exception message
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
	 
	// Handles LabTestNotFoundException and returns a 404 status with an error message.
		 @ExceptionHandler(LabTestNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleLabTestNotFoundException(LabTestNotFoundException pe,
	            WebRequest request) {
	        // Create error message with 404 status code and exception message
	        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	    }
		 
		// Handles AppointmentNotFoundException and returns a 404 status with an error message.
		 @ExceptionHandler(AppointmentNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleAppointmentNotFoundException(AppointmentNotFoundException pe,
	            WebRequest request) {
	        // Create error message with 404 status code and exception message
	        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	    }
}
