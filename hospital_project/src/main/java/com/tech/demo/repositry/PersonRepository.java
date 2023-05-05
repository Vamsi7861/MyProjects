package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Person;



public interface PersonRepository extends JpaRepository<Person, Integer> {

}
