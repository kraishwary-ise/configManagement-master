package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comviva.ConfigurationApp.model.Offer;
import com.comviva.ConfigurationApp.model.OfferLib;
import com.comviva.ConfigurationApp.model.Selection;
import com.comviva.ConfigurationApp.model.SelectionLib;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.SelectionDrag;


@Repository
public class SelectionDaoImpl implements SelectionDao{
	
	private EntityManager entityManager;

	@Autowired
	public SelectionDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}


	@Override
	public List<SelectionLib> getSelection() {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from SelectionLib sl";
		
		Query query = currentSession.createQuery(hql);
		
		List<SelectionLib> results = query.getResultList();
		
		return results;
		
		
	}


	@Override
	public void saveSelection(SelectionDrag[] selectionDrag) {
		

		Session currentSession= entityManager.unwrap(Session.class);
		
		for(int i=0;i<selectionDrag.length;i++) {
		
			String hql = "from UseCase u where u.id=:id";
			
			Query query = currentSession.createQuery(hql);
			
			query.setParameter("id", selectionDrag[i].getId());
			
			List<UseCase> results = query.getResultList();
			
			if(results.isEmpty()) {
			
				return;
				
			}
			else {
				UseCase useCase = results.get(0);
				Selection selection = new Selection(selectionDrag[i].getSelectionName());
				useCase.addSelection(selection);
				currentSession.saveOrUpdate(selection);
			}
		
	}


		
	}
	
	

}
