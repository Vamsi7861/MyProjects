package org.jsp.user.service;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.user.dao.useracess;
import org.jsp.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class userservice {
	@Autowired
private useracess access;        //business logic
	public User saveUser(User u) {
		return access.saveuser(u);
	}
	public User updateuser(User u) {
		
		return access.updateuser(u);
	}
	public User getuserbyid(int id) {
		
       return access.getuserbyid(id);	
		
	}
	public List<User> findAllusers(){
	
		return access.findAllusers();
	}
	public User verifyuser(long phone,String password) {
		
		return access.verifyuser(phone, password);

	}
	public boolean deleteuserbyid(int id) {
		return access.deleteuserbyid(id);
	}
}
