package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.TriggerDrag;

@Repository
public class TriggerDaoImpl implements TriggerDao {
	
	private EntityManager entityManager;

	@Autowired
	public TriggerDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}

	@Override
	@Transactional
	public List<TriggerLib> getTrigger() {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from TriggerLib tl";
		
		Query query = currentSession.createQuery(hql);
		
		List<TriggerLib> results = query.getResultList();
		
		return results;		
}
	
	
	

	@Override
	@Transactional
	public void saveTrigger(TriggerDrag triggerDrag[]) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		for(int i=0;i<triggerDrag.length;i++) {
		
			String hql = "from UseCase u where u.id=:id";
			
			Query query = currentSession.createQuery(hql);
			
			query.setParameter("id", triggerDrag[i].getId());
			
			List<UseCase> results = query.getResultList();
			
			if(results.isEmpty()) {
			
				return;
				
			}
			else {
				UseCase useCase = results.get(0);
				Trigger trigger=new Trigger(triggerDrag[i].getTriggerName());
				useCase.add(trigger);
				currentSession.saveOrUpdate(trigger);
			}
		
	}
	
		
		
		
	}
	
	
	
	
}
	
	

