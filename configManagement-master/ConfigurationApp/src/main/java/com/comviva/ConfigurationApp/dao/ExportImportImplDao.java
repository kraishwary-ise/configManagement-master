package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.UseCase;

@Repository
public class ExportImportImplDao implements ExportImportDao {
	
	private EntityManager entityManager;

	@Autowired
	public ExportImportImplDao(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}

	@Override
	public UseCase exportUseCase(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from UseCase u where u.id=:id";
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("id", id);
		
		List<UseCase> results = query.getResultList();
		
		return results.get(0);
	
		
		
	}


	
}
