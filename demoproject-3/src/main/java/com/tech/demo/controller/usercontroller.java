package com.tech.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;
import com.tech.demo.repo.Userrepo;
import com.tech.demo.service.userservice;
@RestController
public class usercontroller {
	@Autowired
private userservice repo;
	
	@PostMapping("/user")
	public ResponseEntity<Responcestructure<User>> saveUser( @RequestBody User u) {
		return repo.saveUser(u);
	}
	@PutMapping("/user")
	public ResponseEntity<Responcestructure<User>> updateUser(@RequestBody User u) {
		return repo.updateUser(u);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Responcestructure<User>> findUser(@PathVariable int id) {
		return repo.findbyid(id);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Responcestructure<String>> deleteUser(@PathVariable(name="id") int a) {
	return repo.delete(a);
	}
//	@DeleteMapping("/user/{id}")
//	public String deleteUser(@PathVariable(name="id") int a) {
//		User user=repo.findById(a).get();
//		if(user!=null) {                                        //not work invalid input
//			repo.delete(user);
//			return "data deleted";
//		}
//		return null;
//	}
	@GetMapping("/user")
	public ResponseEntity<Responcestructure<List<User>>> findAll(){
		return repo.findall();
	}
	
}
