package org.jsp.demo.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.demo.dto.User;

public class Useraccess {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public User SaveUser(User user) {
		EntityTransaction t = manager.getTransaction();
		manager.persist(user);
		t.begin();
		t.commit();
		return user;

	}

	public User UpdateUser(User user) {
		EntityTransaction t = manager.getTransaction();
		manager.merge(user);
		t.begin();
		t.commit();
		return user;

	}

	public User findUserbyid(int id) {
		return manager.find(User.class, id);
	}

	public boolean DeleteUserbyid(int id) {
		EntityTransaction t = manager.getTransaction();

		User u = manager.find(User.class, id);
		if (u != null) {
			manager.remove(u);
			t.begin();
			t.commit();
			return true;

		}
		return false;
	}
	public User  verifyuser(long phone,String password) {
		Query q=manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<User> user=q.getResultList();
		if(user.size()>0) {
			User u=user.get(0);
			return u;
		}
		return null;
		
	}
}
