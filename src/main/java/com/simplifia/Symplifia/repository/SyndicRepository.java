package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.models.Syndic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyndicRepository extends JpaRepository<Syndic,Integer> {

}
