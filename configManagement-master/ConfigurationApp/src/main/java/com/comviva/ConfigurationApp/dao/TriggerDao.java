package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.response.TriggerDrag;

public interface TriggerDao {
	
	
	
	public List<TriggerLib> getTrigger();

	public void saveTrigger(TriggerDrag triggerDrag[]);

}
