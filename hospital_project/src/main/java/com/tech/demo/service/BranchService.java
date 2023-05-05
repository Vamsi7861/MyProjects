package com.tech.demo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.demo.dao.BranchDao;
import com.tech.demo.dao.HospitalDao;
import com.tech.demo.dto.Branch;
import com.tech.demo.dto.Hospital;
import com.tech.demo.dto.ResponseStructure;



@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hospital_id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		Optional<Hospital> recHospital = hospitalDao.findHospitalById(hospital_id);
		if (!recHospital.isEmpty()) {
			Hospital hospital = recHospital.get();
			hospital.getBranches().add(branch);
			branch.setHospital(hospital);
			branchDao.saveBranch(branch);
			structure.setBody(branch);
			structure.setCode(HttpStatus.CREATED.value());
			structure.setMessage("Branch Saved Succefully");
		} else {
			structure.setBody(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Hospital ID NOT FOUND");
		}
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.NOT_FOUND);
	}
}
