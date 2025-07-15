package com.izyacademy.adapters.in;

import com.izyacademy.adapters.in.dto.LoginRequest;
import com.izyacademy.adapters.in.validation.UserValidation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        UserValidation userValidation = new UserValidation();
        userValidation.validateLogin(request);
        excecuteLogin(request);
        return "Login successful";
    }

    private Boolean excecuteLogin(LoginRequest request) {
        // Logic to authenticate the user, e.g., checking against a database
        // For simplicity, we assume the login is always successful
        // In a real application, you would check the credentials here
        return true;
    }
}
