package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trigger_lib")
public class TriggerLib {


	
	
	@Id
	@Column(name ="name")
	private String name;

	public TriggerLib() {

	}

	public TriggerLib(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
