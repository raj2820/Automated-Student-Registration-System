package com.masai.model;

public class AdminBatchDTO {

	
	private String sname;
	private int roll;
	private int cid;
	private String cname;
	private String batchname;
	private int bid;
	private int seats;
	
	public AdminBatchDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
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

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "AdminBatchDTO [sname=" + sname + ", roll=" + roll + ", cid=" + cid + ", cname=" + cname + ", batchname="
				+ batchname + ", bid=" + bid + ", seats=" + seats + "]";
	}

	
	
	
}
