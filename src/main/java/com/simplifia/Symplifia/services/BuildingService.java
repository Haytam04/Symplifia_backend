package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.dto.BuildingDTO;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.BuildingRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final SyndicRepository syndicRepository;

    public List<BuildingDTO> getAllBuildingsBySyndicId(Integer syndicId) {
        return buildingRepository.findBySyndic_IdSyndic(syndicId)
                .stream()
                .map(BuildingDTO::new)
                .toList();
    }

    public BuildingDTO createBuilding(Integer SyndicId, Building building){
        Syndic syndic = syndicRepository.findById(SyndicId).orElse(null);
        building.setSyndic(syndic);
        Building savedBuilding = buildingRepository.save(building);
        return new BuildingDTO(savedBuilding);
    }


    public BuildingDTO updateBuilding(Integer BuildingId, Integer SyndicId, Building updatedBuilding){
        Building existingBuilding = buildingRepository.findById(BuildingId).orElse(null);
        Syndic relatedSyndic = syndicRepository.findById(SyndicId).orElse(null);

        existingBuilding.setName(updatedBuilding.getName());
        existingBuilding.setLocation(updatedBuilding.getLocation());
        existingBuilding.setSyndicPrice(updatedBuilding.getSyndicPrice());
        existingBuilding.setSyndic(relatedSyndic);

        Building savedBuilding = buildingRepository.save(existingBuilding);

        return new BuildingDTO(savedBuilding);
    }
}
