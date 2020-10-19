package com.comviva.ConfigurationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.SelectionDao;
import com.comviva.ConfigurationApp.model.SelectionLib;
import com.comviva.ConfigurationApp.response.SelectionDrag;

@Service
public class SelectionService {
	
	@Autowired
	private SelectionDao selectionDao;
	

	public List<SelectionLib> getSelection() {
		
		return selectionDao.getSelection();
		
	}


	public void saveSelection(SelectionDrag[] selectionDrag) {
		
		
		selectionDao.saveSelection(selectionDrag);
		
	}

}
