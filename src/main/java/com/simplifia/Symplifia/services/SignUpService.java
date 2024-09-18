package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.ResidentRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final SyndicRepository syndicRepository;
    private final ResidentRepository residentRepository;

    public boolean phoneNumberExists(String phoneNumber) {
        boolean syndicExists = syndicRepository.existsByPhoneNumber(phoneNumber);
        boolean residentExists = residentRepository.existsByPhoneNumber(phoneNumber);
        return syndicExists || residentExists;
    }

    public Syndic registerSyndic(Syndic syndic) {
        syndic.setInscriptionDate(new Date());
        return syndicRepository.save(syndic);
    }

    public Resident registerResident(Resident resident) {
        return residentRepository.save(resident);
    }

}
