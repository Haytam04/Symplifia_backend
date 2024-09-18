package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.LoginRequest;
import com.simplifia.Symplifia.dto.LoginResponse;
import com.simplifia.Symplifia.dto.SignUpRequest;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.services.LoginService;
import com.simplifia.Symplifia.services.ResidentService;
import com.simplifia.Symplifia.services.SignUpService;
import com.simplifia.Symplifia.services.SyndicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final SyndicService syndicService;
    private final ResidentService residentService;
    private final LoginService loginService;
    private final SignUpService signUpService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String phoneNumber = loginRequest.getPhoneNumber();
        String password = loginRequest.getPassword(); // hashed password

        LoginResponse authResponse = loginService.login(phoneNumber, password);

        if (authResponse != null) {
            return ResponseEntity.ok(authResponse);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/check-phone/{phoneNumber}")
    public boolean checkPhoneNumberExists(@PathVariable String phoneNumber) {
        boolean exists = signUpService.phoneNumberExists(phoneNumber);
        return exists;
    }

    @PostMapping("/signup/syndic")
    public ResponseEntity<?> signUpSyndic(@RequestBody Syndic syndic) {
        signUpService.registerSyndic(syndic);
        return ResponseEntity.ok(syndic);
    }
    @PostMapping("/signup/resident")
    public ResponseEntity<?> signUpResident(@RequestBody Resident resident) {
        signUpService.registerResident(resident);
        return ResponseEntity.ok(resident);
    }
}
