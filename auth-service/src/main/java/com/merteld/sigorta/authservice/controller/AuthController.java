package com.merteld.sigorta.authservice.controller;

import com.merteld.sigorta.authservice.dto.RegisterDto;
import com.merteld.sigorta.authservice.dto.TokenDto;
import com.merteld.sigorta.authservice.request.LoginRequest;
import com.merteld.sigorta.authservice.request.RegisterRequest;
import com.merteld.sigorta.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
