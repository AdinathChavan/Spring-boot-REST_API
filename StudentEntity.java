package com.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	
	@Id
	private int id;
	
	private String name;
	
	private double marks;
	
	private long mobileno;
	
	private String village;
	
	public StudentEntity() {
		
	}

	public StudentEntity(int id, String name, double marks, long mobileno, String village) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.mobileno = mobileno;
		this.village = village;
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

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

}
