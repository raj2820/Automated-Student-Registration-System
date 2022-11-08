package com.masai.model;

public class Student {

	
	private int roll;
	private String name;

	private String username;
	private String password;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String name,  String username, String password) {
		super();
		this.roll = roll;
		this.name = name;
		
		this.username = username;
		this.password = password;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

	public String getUserName() {
		return username;
	}

	public void setEmail(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name +  ", email=" + username + ", password="
				+ password + "]";
	}
	
}
