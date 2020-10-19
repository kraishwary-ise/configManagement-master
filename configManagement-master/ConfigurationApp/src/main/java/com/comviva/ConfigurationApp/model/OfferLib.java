package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="offer_lib")
public class OfferLib {
	
	@Id
	@Column(name ="offer_name")
	private String name;
	
	public OfferLib() {
		
	}

	public OfferLib(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
