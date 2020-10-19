package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.User;

@Repository
public class UserDaoImpl implements UserDAO {
	
	
	private EntityManager entityManager;
	
	
	@Autowired
	public UserDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}


	@Override
	@Transactional
	public User fetchUserByEmailAndPassword(String userEmail,String password) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from User u where u.userEmail=:userEmail and u.password=:password";
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("userEmail", userEmail);
		query.setParameter("password", password);
		
		List<User> results = query.getResultList();
		
		if(results.isEmpty()) {
			return null;
		}
		
		return results.get(0);
		
		
		
		
	}

}
