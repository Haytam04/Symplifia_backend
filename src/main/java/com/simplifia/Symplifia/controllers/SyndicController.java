package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.BuildingDTO;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.BuildingRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import com.simplifia.Symplifia.services.BuildingService;
import com.simplifia.Symplifia.services.SyndicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SyndicController {

    private final BuildingService buildingService;
    private final SyndicService syndicService;
    private final SyndicRepository syndicRepository;

    @GetMapping("syndics")
    public ResponseEntity<List<Syndic>> getAllSyndics() {
        List<Syndic> syndics = syndicRepository.findAll();
        return ResponseEntity.ok(syndics);
    }


}




