package com.security.model;

public class Subject 
{
	private int subId;
	private String subName;
	
	
	public Subject(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + "]";
	}
	
	
}
