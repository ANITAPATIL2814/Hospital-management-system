package com.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

// Custom validator for phone numbers
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private static final String PHONE_PATTERN = "^[6-9]{1}[0-9]{9}$"; // 10 digits, starts with 6-9

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // null values are invalid
        }
        return Pattern.matches(PHONE_PATTERN, value); // Apply the regex pattern
    }
}
