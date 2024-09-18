package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;


@Service
@RequiredArgsConstructor
public class SyndicService {

    private final SyndicRepository syndicRepository;


    public Syndic createSyndic(Syndic syndic){
      // Syndic existSyndic = syndicRepository.findByPhoneNumber(syndic.getPhoneNumber());
        syndic.setInscriptionDate(new Date());
        return syndicRepository.save(syndic);
    }
}
