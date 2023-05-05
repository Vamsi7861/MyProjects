package com.tech.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.User;

public interface Userrepo extends JpaRepository<User, Integer> {

}
