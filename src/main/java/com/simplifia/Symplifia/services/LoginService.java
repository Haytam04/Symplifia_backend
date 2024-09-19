package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.dto.LoginResponse;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.ResidentRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SyndicRepository syndicRepository;
    private final ResidentRepository residentRepository;

    public LoginResponse login(String phoneNumber, String password){
        Optional<Syndic> syndic = syndicRepository.findByPhoneNumberAndPassword(phoneNumber, password);
        if (syndic.isPresent()) {
            return new LoginResponse(syndic.get().getIdSyndic(), "syndic");
        }

        // Search in Resident table
        Optional<Resident> resident = residentRepository.findByPhoneNumberAndPassword(phoneNumber, password);
        if (resident.isPresent()) {
            return new LoginResponse(resident.get().getIdResident(), "resident");
        }
        return null;
    }
}
