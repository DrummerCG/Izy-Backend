package com.izyacademy.adapters.in.validation;

import com.izyacademy.adapters.in.dto.LoginRequest;

public class UserValidation {

    public void validateLogin(LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!request.getEmail().matches(emailRegex)) {
            throw new ValidationException("El correo no tiene un formato válido");
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new ValidationException("Password cannot be empty");
        }
        if (request.getPassword().length() < 8) {
            throw new ValidationException("La contraseña debe tener al menos 8 caracteres");
        }
    }
}
