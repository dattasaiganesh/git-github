package com.java;

import java.util.Date;

public class Emp {
	
	
	private String name;
	private float salary;
	private Date date;
	private Date delivereddate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	private String designation;
	
public Emp(){}
public Emp(int id, String name, float salary, String designation){
	super();
	this.name= name;
	this.salary =salary;
	this.designation = designation;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Date getDelivereddate() {
	return delivereddate;
}
public void setDelivereddate(Date delivereddate) {
	this.delivereddate = delivereddate;
}
}
