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
@Table(name="offers")
public class Offer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="offer_id")
	private int id;
	
	
	
	@Column(name="offer_name")
	private String offerName;
	
	
	@ManyToOne()
	@JoinColumn(name="idusecase")
	private UseCase useCase;
	
	
	public Offer() {
		
	}
	
	public Offer(String offerName) {
		this.offerName = offerName;
	}

	public Offer(int id, String offerName) {
		this.id = id;
		this.offerName = offerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public UseCase getUseCase() {
		return useCase;
	}

	public void setUseCase(UseCase useCase) {
		this.useCase = useCase;
	}
	
	
	
	
	

}
