package com.itbank.dao;

import java.util.Date;

/*
 * 	NAME	VARCHAR2(100 BYTE)
	AMOUNT	NUMBER
	PRICE	NUMBER
	TIME	DATE
*/

public class SalesVO {
	
	private String name;
	private int amount;
	private int price;
	private Date time;
	private String buyer;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
