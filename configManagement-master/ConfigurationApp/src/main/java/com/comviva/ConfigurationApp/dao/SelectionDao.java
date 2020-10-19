package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.SelectionLib;
import com.comviva.ConfigurationApp.response.SelectionDrag;

public interface SelectionDao {
	
	
	public List<SelectionLib> getSelection();

	public void saveSelection(SelectionDrag[] selectionDrag);

}
