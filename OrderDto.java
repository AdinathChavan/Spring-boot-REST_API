package com.webapp.DTO;

public class OrderDto {
	
	private String product;
	private double prize;
	private String adderess;
	private String gender;
	private long mobileno;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public String getAdderess() {
		return adderess;
	}
	public void setAdderess(String adderess) {
		this.adderess = adderess;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "OrderDto [product=" + product + ", prize=" + prize + ", adderess=" + adderess + ", gender=" + gender
				+ ", mobileno=" + mobileno + "]";
	}


}
