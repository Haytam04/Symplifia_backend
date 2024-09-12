package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SyndicService {

    private final SyndicRepository syndicRepository;

    public Syndic authenticate(String phoneNumber, String password) {
        return syndicRepository.findByPhoneNumberAndPassword(phoneNumber, password).orElse(null);
    }

    public Syndic createSyndic(Syndic syndic){
//       Syndic existSyndic = syndicRepository.findByPhoneNumber(syndic.getPhoneNumber());
       syndic.setInscriptionDate(new Date());
       return syndicRepository.save(syndic);
    }
}
