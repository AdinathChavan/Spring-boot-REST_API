package com.webapp.request;

public class RequestData {
	
	private int id;
	
	private String name;
	
	private double salary;
	
	private int pincode;
	
	public RequestData() {
		
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public RequestData(int id, String name, double salary, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.pincode = pincode;
	}

}
