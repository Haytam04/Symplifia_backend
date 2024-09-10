package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.BuildingDTO;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.BuildingRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import com.simplifia.Symplifia.services.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SyndicController {

    private final BuildingService buildingService;
    private final SyndicRepository syndicRepository;

    @GetMapping("syndics")
    public ResponseEntity<List<Syndic>> getAllSyndics(){
        List<Syndic> syndics = syndicRepository.findAll();
        return ResponseEntity.ok(syndics);
    }




}
