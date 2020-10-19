package com.comviva.ConfigurationApp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


@Entity
@Table(name="usecase")
public class UseCase {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusecase")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="sdate")
	private Date sdate;
	
	@Column(name="edate")
	private Date edate;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="campeing")
	private String campeing;
	
	@Column(name="businesslogic")
	private String businesslog;
	
	
	@OneToMany(mappedBy="useCase", cascade = CascadeType.ALL)
	private List<Trigger> triggers;
	
	@OneToMany(mappedBy="useCase", cascade = CascadeType.ALL)
	private List<Offer> offers;
	
	@OneToMany(mappedBy="useCase", cascade = CascadeType.ALL)
	private List<Selection> selection;
	
	
	public UseCase() {
	
	}
	
	public UseCase(String name, String desc, Date sdate, Date edate, String direction,String campeing, String businesslog) {
		this.name = name;
		this.desc = desc;
		this.sdate = sdate;
		this.edate = edate;
		this.direction = direction;
		this.campeing = campeing;
		this.businesslog = businesslog;
	}
	
	public UseCase(String name, String desc, Date sdate, Date edate, String direction, String campeing,
			String businesslog, List<Trigger> triggers) {
		this.name = name;
		this.desc = desc;
		this.sdate = sdate;
		this.edate = edate;
		this.direction = direction;
		this.campeing = campeing;
		this.businesslog = businesslog;
		this.triggers = triggers;
	}
	
	
	public UseCase(int id, String name, String desc, Date sdate, Date edate, String direction, String campeing,
			String businesslog, List<Trigger> triggers, List<Offer> offers) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.sdate = sdate;
		this.edate = edate;
		this.direction = direction;
		this.campeing = campeing;
		this.businesslog = businesslog;
		this.triggers = triggers;
		this.offers = offers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCampeing() {
		return campeing;
	}
	public void setCampeing(String campeing) {
		this.campeing = campeing;
	}
	public String getBusinesslog() {
		return businesslog;
	}
	public void setBusinesslog(String businesslog) {
		this.businesslog = businesslog;
	}
		
	
	


	public List<Trigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(List<Trigger> triggers) {
		this.triggers = triggers;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	
	

	public List<Selection> getSelection() {
		return selection;
	}

	public void setSelection(List<Selection> selection) {
		this.selection = selection;
	}

	public void add(Trigger tempTrigger) {
		
		if(triggers==null) {
			
			triggers  = new ArrayList<>(); 
			
		}
		triggers.add(tempTrigger);
		
		tempTrigger.setUseCase(this);
		
	}
	
	
	public void addOffer(Offer tempOffer) {
		
		if(offers==null) {
			offers = new ArrayList<>();
		}
		
		offers.add(tempOffer);	
		
		tempOffer.setUseCase(this);
	}
	
	
	
	public void addSelection(Selection tempSelection) {
		
		if(selection==null) {
			selection = new ArrayList<>();
		}
		
		selection.add(tempSelection);	
		
		tempSelection.setUseCase(this);
	}

	

	@Override
	public String toString() {
		return "UseCase [id=" + id + ", name=" + name + ", desc=" + desc + ", sdate=" + sdate + ", edate=" + edate
				+ ", direction=" + direction + ", campeing=" + campeing + ", businesslog=" + businesslog + ", triggers="
				+ triggers + "]";
	}
	
	
	
	
	
}
