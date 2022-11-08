package com.masai.model;

public class Course {

	private int cid;
	private String cname;
	private int fee;
	private String duration;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(int cid, String cname, int fee, String duration) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fee = fee;
		this.duration = duration;
	}


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


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", fee=" + fee + ", duration=" + duration + "]";
	}
	
}
