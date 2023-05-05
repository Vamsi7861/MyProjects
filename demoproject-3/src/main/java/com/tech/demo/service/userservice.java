package com.tech.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.demo.dao.userdao;
import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;
import com.tech.demo.exception.idnotfoundexception;

@Service
public class userservice {
	@Autowired
private userdao dao;

public ResponseEntity<Responcestructure<User>> saveUser(User u) {
	Responcestructure<User> structure=new Responcestructure<User>();
	structure.setBody(dao.saveUser(u));
	structure.setMessage("user saved successfully");
	structure.setCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<Responcestructure<User>>(structure, HttpStatus.ACCEPTED);
}
public ResponseEntity<Responcestructure<User>> updateUser(User u) {
	Responcestructure<User> structure=new Responcestructure<User>();
	structure.setBody(dao.updateUser(u));
	structure.setMessage("user updated successfully");
	structure.setCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<Responcestructure<User>>(structure, HttpStatus.ACCEPTED);
	}
public ResponseEntity<Responcestructure<User>> findbyid(int id){
	Optional<User> user=dao.findbyid(id);
	Responcestructure<User> structure=new Responcestructure<User>();
	if(user.isPresent()) {
		
	structure.setBody(user.get());
	structure.setMessage("user found successfully");
	structure.setCode(HttpStatus.FOUND.value());
	return new ResponseEntity<Responcestructure<User>>(structure, HttpStatus.FOUND);
	}
	else {
	
//		structure.setBody(null);
//		structure.setMessage("invalid id");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<Responcestructure<User>>(structure, HttpStatus.NOT_FOUND);
		 throw new idnotfoundexception();
	}
		
			}
public ResponseEntity<Responcestructure<String>> delete( int id) {
	Optional<User> user=dao.findbyid(id);
	Responcestructure<String> structure=new Responcestructure<String>();
	if(user.isPresent()) {
		
		structure.setBody("user deleted");
		structure.setMessage("user found successfully");
		structure.setCode(HttpStatus.OK.value());
		dao.delete(user.get());
		return new ResponseEntity<Responcestructure<String>>(structure, HttpStatus.OK);
	}
	else {
		 throw new idnotfoundexception();
	}
}
public ResponseEntity<Responcestructure<List<User>>> findall(){
	Responcestructure<List<User>> structure=new Responcestructure<>();
structure.setBody(dao.findall());
	structure.setMessage("list of all users");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<Responcestructure<List<User>>>(structure, HttpStatus.OK);
}
}
