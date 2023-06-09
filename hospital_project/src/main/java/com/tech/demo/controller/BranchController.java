package com.tech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.Branch;
import com.tech.demo.dto.ResponseStructure;
import com.tech.demo.service.BranchService;



@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,
			@RequestParam int hospital_id) {
		return branchService.saveBranch(branch, hospital_id);
	}

	@GetMapping("/getb")
	public Branch getBranch() {
		return new Branch();
	}
}
