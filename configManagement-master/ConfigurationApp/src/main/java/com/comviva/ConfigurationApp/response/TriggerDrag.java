package com.comviva.ConfigurationApp.response;

public class TriggerDrag {
	
	private int id;
	private String triggerName;
	
	public TriggerDrag(){
		
	}
	
	public TriggerDrag(int id, String triggerName) {
		super();
		this.id = id;
		this.triggerName = triggerName;
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

	@Override
	public String toString() {
		return "TriggerDrag [id=" + id + ", triggerName=" + triggerName + "]";
	}
	
	
	
	
	
	

}
