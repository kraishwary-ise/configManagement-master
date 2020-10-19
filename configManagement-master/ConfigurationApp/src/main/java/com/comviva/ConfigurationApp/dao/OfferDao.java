package com.comviva.ConfigurationApp.dao;


import java.util.List;

import com.comviva.ConfigurationApp.model.OfferLib;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.response.TriggerDrag;


public interface OfferDao {
	
	public List<OfferLib> getOffer();


	public void saveOffer(OfferDrag[] offerDrag);

}
