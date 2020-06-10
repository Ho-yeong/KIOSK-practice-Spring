package com.itbank.dao;

import java.util.Date;

/*
 * 	NAME	VARCHAR2(100 BYTE)
	AMOUNT	NUMBER
	PRICE	NUMBER
	TIME	DATE
 * */

public class ProductVO {
	
	private String name;
	private int amount;
	private String price;
	private Date time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
