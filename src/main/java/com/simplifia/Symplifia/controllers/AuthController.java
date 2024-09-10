package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.LoginRequest;
import com.simplifia.Symplifia.dto.LoginResponse;
import com.simplifia.Symplifia.dto.ResidentDTO;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.services.ResidentService;
import com.simplifia.Symplifia.services.SyndicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final SyndicService syndicService;
    private final ResidentService residentService;

    @PostMapping("/syndic-login")
    public ResponseEntity<?> loginSyndic(@RequestBody LoginRequest loginRequest) {

        Syndic syndic = syndicService.authenticate(loginRequest.getPhoneNumber(), loginRequest.getPassword());
        if (syndic != null) {
            return ResponseEntity.ok(new LoginResponse(true, syndic));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null));
    }

    @PostMapping("/resident-login")
    public ResponseEntity<?> loginResident(@RequestBody LoginRequest loginRequest) {
        Resident resident = residentService.authenticate(loginRequest.getPhoneNumber(), loginRequest.getPassword());

        if (resident != null) {
            return ResponseEntity.ok(new LoginResponse(true, resident));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null));
    }

    @PostMapping("/post-syndic")
    public ResponseEntity<Syndic> createSyndic(@RequestBody Syndic syndic) {
        try {
            Syndic newSyndic = syndicService.createSyndic(syndic);
            return new ResponseEntity<>(newSyndic, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
