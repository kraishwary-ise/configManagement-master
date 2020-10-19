package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="triggers")
public class Trigger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtrigger")
	private int id;
	
	
	@Column(name="triggername")
	private String triggerName;
	
	
	@ManyToOne()
	@JoinColumn(name="idusecase")
	private UseCase useCase;
	
	
	public Trigger() {
		
	}

	

	public Trigger(String triggerName) {
		this.triggerName = triggerName;
	}



	public Trigger(int triggerId, String triggerName) {
		
	this.id=triggerId;
	this.triggerName=triggerName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}



	public UseCase getUseCase() {
		return useCase;
	}



	public void setUseCase(UseCase useCase) {
		this.useCase = useCase;
	}



	

	
	

}
