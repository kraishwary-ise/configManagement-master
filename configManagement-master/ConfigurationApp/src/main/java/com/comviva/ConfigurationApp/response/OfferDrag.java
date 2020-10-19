package com.comviva.ConfigurationApp.response;

public class OfferDrag {
	
	private int id;
	private String offerName;
	
	OfferDrag() {
		
	}
	
	
	
	public OfferDrag(int id, String offerName) {
		super();
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



	@Override
	public String toString() {
		return "OfferDrag [id=" + id + ", offerName=" + offerName + "]";
	}
	
	
	

}
