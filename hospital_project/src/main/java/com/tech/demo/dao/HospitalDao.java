package com.tech.demo.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.Hospital;
import com.tech.demo.repositry.HospitalRepository;



@Repository
public class HospitalDao {
	@Autowired
	HospitalRepository repository;

	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}

	public Optional<Hospital> findHospitalById(int id) {
		return repository.findById(id);
	}

	public void delete(Hospital hospital) {
		repository.delete(hospital);
	}

	public List<Hospital> getAllHospitals() {
		return repository.findAll();
	}
}
