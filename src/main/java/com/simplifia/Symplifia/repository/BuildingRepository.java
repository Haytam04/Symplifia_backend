package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer> {
    List<Building> findBySyndic_IdSyndic(Integer syndicId);
}
