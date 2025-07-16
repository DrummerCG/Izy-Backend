package com.izyacademy.adapters.in.validation;

public final class ValidationConstants {

    // Mensajes comunes
    public static final String EMAIL_CANNOT_BE_EMPTY = "Email cannot be empty";
    public static final String INVALID_EMAIL_FORMAT = "El correo no tiene un formato válido";
    public static final String PASSWORD_CANNOT_BE_EMPTY = "Password cannot be empty";
    public static final String PASSWORD_MIN_LENGTH = "La contraseña debe tener al menos 8 caracteres";

    // Regex
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private ValidationConstants() {
    }
}