package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="selection_lib")
public class SelectionLib {
	
	
	@Id
	@Column(name ="name")
	private String name;

	public SelectionLib() {

	}

	public SelectionLib(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
