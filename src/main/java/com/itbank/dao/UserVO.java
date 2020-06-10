package com.itbank.dao;

import java.util.Date;

/*
 * 	PNUM	VARCHAR2(20 BYTE)
	NAME	VARCHAR2(50 BYTE)
	STAMP	NUMBER
	USERNUM	NUMBER
	REGISTDATE	DATE
 * */

public class UserVO {
	private String pnum;
	private String name;
	private int stamp;
	private int usernum;
	private Date registdate;
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	
	
}
