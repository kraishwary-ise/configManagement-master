package com.comviva.ConfigurationApp.response;

import java.util.Date;

public class UseCaseResponse {
	
	private int id;
	private String name;
	private String desc;
	private String type;
	private Date sdate;
	private Date edate;
	private String Status;
	private String env;
	
	
	UseCaseResponse() {
		
	}

	

	public UseCaseResponse(int id, String name, String desc, String type, Date sdate, Date edate, 
			String status, String env) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.type = type;
		this.sdate = sdate;
		this.edate = edate;
		this.Status = status;
		this.env = env;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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




	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public String getEnv() {
		return env;
	}


	public void setEnv(String env) {
		this.env = env;
	}
	
	

}
