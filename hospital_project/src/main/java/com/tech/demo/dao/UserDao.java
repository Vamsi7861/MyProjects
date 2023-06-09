package com.tech.demo.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.User;
import com.tech.demo.repositry.UserRepository;


@Repository
public class UserDao {
	@Autowired
	UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}

	public void delete(User user) {
		repository.delete(user);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}
}
