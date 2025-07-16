package com.izyacademy.adapters.in;

import com.izyacademy.adapters.in.dto.LoginRequest;
import com.izyacademy.adapters.in.dto.RegisterRequest;
import com.izyacademy.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // El servicio devuelve el nombre del usuario si el login es exitoso.
        String userName = authService.login(request);
        // Si el login es exitoso, devolvemos un 200 OK con el nombre del usuario.
        return ResponseEntity.ok(userName);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        // Delegamos el registro al servicio.
        authService.register(request);
        // Devolvemos un 201 Created para indicar que el recurso se creó con éxito.
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful");
    }
}
