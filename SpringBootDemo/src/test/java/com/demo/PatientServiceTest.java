package com.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.entity.Patient;
import com.demo.repository.PatientRepository;
import com.demo.service.PatientService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = SpringBootDemoApplication.class)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    private Patient patient;

    private Validator validator;

    @BeforeEach
    void setUp() {
        // Initialize the patient object
        patient = new Patient();
        patient.setPatientId(1);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateofbirth("1990-01-01");
        patient.setContactNumber("9632587410"); // Invalid phone number
        patient.setEmailID("john.doe@example.com");
        patient.setAddress("123 Main St");
        patient.setBoodGroup("O+");
        patient.setWeight(70);
        patient.setHeight(180);

        // Initialize the validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testAddPatientWithInvalidPhoneNumber() {
        // Trigger the validation
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);

        // Print all violations for debugging
        violations.forEach(violation -> System.out.println("Violation: " + violation.getPropertyPath() + " - " + violation.getMessage()));

        // Assert that the validation finds an error for the invalid phone number
        assertFalse(violations.isEmpty(), "Validation should fail for invalid phone number");

        // Assert the specific validation message
        violations.forEach(violation -> {
            if (violation.getPropertyPath().toString().equals("contactNumber")) {
                assertEquals("Phone number should be exactly 10 digits & Start with 6/7/8/9", violation.getMessage());
            }
        });
    }


    // Test method for fetching all patients
    @Test
    void testGetAllPatients() {
        when(patientRepository.findAll()).thenReturn(List.of(patient));

        // Call the service method
        List<Patient> patients = patientService.getAllPatients();

        // Assert that the returned list is not null and contains the expected number of patients
        assertNotNull(patients);
        assertEquals(1, patients.size());
        assertEquals(patient, patients.get(0)); // Check if the first patient in the list is our mocked patient
        verify(patientRepository, times(1)).findAll(); // Verify repository findAll method was called
    }
}
