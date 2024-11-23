package com.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false; // If the value is null or empty, it's considered invalid
        }
        
        // Regex to validate a phone number (basic example, adjust as needed)
        String phoneRegex = "^[6789]\\d{9}$";  // For a 10-digit phone number
        return value.matches(phoneRegex);
    }
}

