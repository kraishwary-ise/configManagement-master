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
@Table(name="selection")
public class Selection {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="selection_id")
	private int id;
	
	
	
	@Column(name="name")
	private String selectionName;
	
	
	@ManyToOne()
	@JoinColumn(name="idusecase")
	private UseCase useCase;
	
	Selection() {
		
	}

	public Selection(String selectionName) {
		super();
		this.selectionName = selectionName;
	}

	public Selection(int id, String selectionName) {
		this.id = id;
		this.selectionName = selectionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelectionName() {
		return selectionName;
	}

	public void setSelectionName(String selectionName) {
		this.selectionName = selectionName;
	}

	public UseCase getUseCase() {
		return useCase;
	}

	public void setUseCase(UseCase useCase) {
		this.useCase = useCase;
	}
	
	
	

}
