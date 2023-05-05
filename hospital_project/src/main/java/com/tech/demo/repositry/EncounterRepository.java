package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Encounter;



public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
