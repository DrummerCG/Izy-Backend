package com.izyacademy.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class LoginRequest {
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
}
