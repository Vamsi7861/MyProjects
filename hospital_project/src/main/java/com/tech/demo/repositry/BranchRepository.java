package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Branch;



public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
