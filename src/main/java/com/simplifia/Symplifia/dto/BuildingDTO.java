package com.simplifia.Symplifia.dto;

import com.simplifia.Symplifia.models.Building;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BuildingDTO {
    private Integer idBuilding;
    private String name;
    private BigDecimal syndicPrice;
    private String location;

    // Constructor to convert Building entity to BuildingDTO
    public BuildingDTO(Building building) {
        this.idBuilding = building.getIdBuilding();
        this.name = building.getName();
        this.syndicPrice = building.getSyndicPrice();
        this.location = building.getLocation();
    }
}
