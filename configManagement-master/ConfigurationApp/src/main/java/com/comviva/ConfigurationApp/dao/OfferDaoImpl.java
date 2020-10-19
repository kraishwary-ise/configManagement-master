package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.Offer;
import com.comviva.ConfigurationApp.model.OfferLib;
import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.response.TriggerDrag;


@Repository
public class OfferDaoImpl implements OfferDao {
	
	private EntityManager entityManager;

	@Autowired
	public OfferDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}

	@Override
	@Transactional
	public List<OfferLib> getOffer() {
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from OfferLib ol";
		
		Query query = currentSession.createQuery(hql);
		
		List<OfferLib> results = query.getResultList();
		
		return results;
	}

	@Override
	@Transactional

	public void saveOffer(OfferDrag[] offerDrag)  {
	
	
	Session currentSession= entityManager.unwrap(Session.class);
	
	for(int i=0;i<offerDrag.length;i++) {
	
		String hql = "from UseCase u where u.id=:id";
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("id", offerDrag[i].getId());
		
		List<UseCase> results = query.getResultList();
		
		if(results.isEmpty()) {
		
			return;
			
		}
		else {
			UseCase useCase = results.get(0);
			Offer offer=new Offer(offerDrag[i].getOfferName());
			useCase.addOffer(offer);
			currentSession.saveOrUpdate(offer);
		}
	
}

	
	
	
}


	
	

}
