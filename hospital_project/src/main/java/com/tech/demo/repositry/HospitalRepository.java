package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Hospital;



public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
