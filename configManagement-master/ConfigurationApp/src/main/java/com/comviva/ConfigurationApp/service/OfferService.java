package com.comviva.ConfigurationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.OfferDao;
import com.comviva.ConfigurationApp.model.OfferLib;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.response.TriggerDrag;

@Service
public class OfferService {
	
	@Autowired
	private OfferDao offerDao;
	
	
	public List<OfferLib> getOffer() {
		
		return offerDao.getOffer();
		
	}


	public void saveOffer(OfferDrag[] offerDrag) {
		
		offerDao.saveOffer(offerDrag);
		
	}


}
