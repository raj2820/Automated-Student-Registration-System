package com.masai.model;

public class AdminStudentCourseDTO {
 
	private int roll;
	private String sname;
	private String username;

	private String cname;
	private String duration;
	
	public AdminStudentCourseDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String susername) {
		this.username = susername;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "StudentCourseDTO [roll=" + roll + ", sname=" + sname + ", username=" + username + ", cname=" + cname
				+ ", duration=" + duration + "]";
	}
	
	
	
	
	
	
	
	
}
