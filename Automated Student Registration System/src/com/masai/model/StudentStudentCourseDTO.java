package com.masai.model;

public class StudentStudentCourseDTO {
 private int cid;
 private String cname;
 private int fee;

 
 public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public int getFee() {
	return fee;
}

public void setFee(int fee) {
	this.fee = fee;
}

//public String getDuration() {
//	return duration;
//}
//
//public void setDuration(String duration) {
//	this.duration = duration;
//}
//
//public int getTotal_students() {
//	return total_students;
//}
//
//public void setTotal_students(int total_students) {
//	this.total_students = total_students;
//}

public StudentStudentCourseDTO() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "StudentStudentCourseDTO [cid=" + cid + ", cname=" + cname + ", fee=" + fee +  "]";
}
 
 
 
	
	
	
	
	
}
