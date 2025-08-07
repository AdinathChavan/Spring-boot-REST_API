package com.webapp.request;

public class RequestDTO {
	
	private int id;
	
	private String name;
	
	private double price;
	
	private String address;
	
	private int pincode;
	
	public RequestDTO() {
		
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public RequestDTO(int id, String name, double price, String address, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.address = address;
		this.pincode = pincode;
	}

}
