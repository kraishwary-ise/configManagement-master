package com.comviva.ConfigurationApp.response;

public class SelectionDrag {
	
	private int id;
	private String SelectionName;
	
	SelectionDrag() {
		
	}

	public SelectionDrag(int id, String selectionName) {
		super();
		this.id = id;
		SelectionName = selectionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelectionName() {
		return SelectionName;
	}

	public void setSelectionName(String selectionName) {
		SelectionName = selectionName;
	}

	@Override
	public String toString() {
		return "SelectionDrag [id=" + id + ", SelectionName=" + SelectionName + "]";
	}

	
	
	

}
