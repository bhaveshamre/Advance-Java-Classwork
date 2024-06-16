package com.student.model;

public class StudentModel {
	private int id;
	private String name;
	private float marks;
	private int phone;
	private String gender;
	private String city;
	
	public StudentModel(int id, String name, float marks, int phone, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", marks=" + marks + ", phone=" + phone + ", gender="
				+ gender + ", city=" + city + "]";
	}


	public StudentModel() {}
	
	
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
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int num) {
		this.phone = num;
	}
	
	

}
