package com.softeem.pp.dto;

import java.util.Date;

public class Photo {

	private int pid;
	private String pname;
	private Date puploadTime;
	private String pdiscription;
	private int aid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getPuploadTime() {
		return puploadTime;
	}
	public void setPuploadTime(Date puploadTime) {
		this.puploadTime = puploadTime;
	}
	public String getPdiscription() {
		return pdiscription;
	}
	public void setPdiscription(String pdiscription) {
		this.pdiscription = pdiscription;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

}
