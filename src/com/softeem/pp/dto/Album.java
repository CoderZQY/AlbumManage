package com.softeem.pp.dto;

import java.util.Date;

public class Album {
	
	private int aid;
	private String aname;
	private Date acreateTime;
	private String adiscription;
	private int uid;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Date getAcreateTime() {
		return acreateTime;
	}
	public void setAcreateTime(Date acreateTime) {
		this.acreateTime = acreateTime;
	}
	public String getAdiscription() {
		return adiscription;
	}
	public void setAdiscription(String adiscription) {
		this.adiscription = adiscription;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
