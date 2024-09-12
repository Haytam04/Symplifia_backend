package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.models.Syndic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SyndicRepository extends JpaRepository<Syndic,Integer> {
    Optional<Syndic> findByPhoneNumberAndPassword(String phoneNumber, String password);

    Syndic findByPhoneNumber(String phoneNumber);

    List<Syndic> findAll();
}
