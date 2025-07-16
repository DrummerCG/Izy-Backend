package com.izyacademy.adapters.in.validation;

import com.izyacademy.adapters.in.dto.LoginRequest;
import com.izyacademy.adapters.in.dto.RegisterRequest;
import com.izyacademy.adapters.in.validation.ValidationException;
import static com.izyacademy.adapters.in.validation.ValidationConstants.*;

public class UserValidation {

    public void validateLogin(LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ValidationException(EMAIL_CANNOT_BE_EMPTY);
        }
        if (!request.getEmail().matches(EMAIL_REGEX)) {
            throw new ValidationException(INVALID_EMAIL_FORMAT);
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new ValidationException(PASSWORD_CANNOT_BE_EMPTY);
        }
        if (request.getPassword().length() < 8) {
            throw new ValidationException(PASSWORD_MIN_LENGTH);
        }
    }

    public void validateRegister(RegisterRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ValidationException(EMAIL_CANNOT_BE_EMPTY);
        }
        if (!request.getEmail().matches(EMAIL_REGEX)) {
            throw new ValidationException(INVALID_EMAIL_FORMAT);
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new ValidationException(PASSWORD_CANNOT_BE_EMPTY);
        }
        if (request.getPassword().length() < 8) {
            throw new ValidationException(PASSWORD_MIN_LENGTH);
        }
    }
}