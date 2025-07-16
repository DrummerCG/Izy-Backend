package com.izyacademy.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
