package org.jsp.user.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class useracess {
	@Autowired
private EntityManager manager;
	public User saveuser(User u) { 
		EntityTransaction t=manager.getTransaction();
		manager.persist(u);
		t.begin();
		t.commit();
		return u;
		
	}
	public User updateuser(User u) {
		EntityTransaction t=manager.getTransaction();
		manager.merge(u);
		t.begin();
		t.commit();
		return u;
	}
	public User getuserbyid(int id) {
		
       return manager.find(User.class,id);		
		
	}
	public List<User> findAllusers(){
		Query q=manager.createQuery("select u from User u");
		List<User> l=q.getResultList();
		return l;
	}
	public User verifyuser(long phone,String password) {
		Query q=manager.createQuery("select u from User u where u.password=?2 and u.phone=?1");
		q.setParameter(1,phone);
		q.setParameter(2, password);
		try {
		//List<User> u= q.getResultList();
		//	if(u.size()>0) {
		//		return u.get(0);
		//	}
			User u=(User) q.getSingleResult();
			if(u!=null) {
				return u;
			}
				
		}
		catch(NoResultException e) {
			System.out.println("invalid input");
		}
		return null;

	}
	public boolean deleteuserbyid(int id) {
		EntityTransaction t=manager.getTransaction();
	      User u=manager.find(User.class,id);
	      if(u!=null){
	    	  manager.remove(u);
	    	  t.begin();t.commit();
	    	  return true;
	    	  
	      }
	      return false;
			
		}
	
}
