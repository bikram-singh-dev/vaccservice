package com.vaccnow.vaccservice.dto;

public class VaccineDTO {

	private int id;
	private String name;
	private String desc;
	private int reqDoses;
	private long availableNo;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getReqDoses() {
		return reqDoses;
	}
	public void setReqDoses(int reqDoses) {
		this.reqDoses = reqDoses;
	}
	public long getAvailableNo() {
		return availableNo;
	}
	public void setAvailableNo(long availableNo) {
		this.availableNo = availableNo;
	}
	
	
}
