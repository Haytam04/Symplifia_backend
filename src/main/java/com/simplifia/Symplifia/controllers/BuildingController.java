package com.simplifia.Symplifia.controllers;


import com.simplifia.Symplifia.dto.BuildingDTO;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.services.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/syndics/{syndicId}/buildings")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping
    public List<BuildingDTO> getBuildingBySyndicId(@PathVariable Integer syndicId) {
        return buildingService.getAllBuildingsBySyndicId(syndicId);
    }

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@PathVariable Integer syndicId, @RequestBody Building building) {
       BuildingDTO buildingDTO = buildingService.createBuilding(syndicId, building);
        return ResponseEntity.ok(buildingDTO);
    }

    @PutMapping("/{buildingId}")
    public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable Integer buildingId, @PathVariable Integer syndicId, @RequestBody Building building){
        BuildingDTO updatedBuilding =  buildingService.updateBuilding(buildingId,syndicId,building);
        return ResponseEntity.ok(updatedBuilding);
    }
}
