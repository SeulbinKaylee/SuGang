package com.sugang.dto;

public class DtoStudent {
	private String st_name;
	private String st_no;
	private String phone_number;
	public DtoStudent() {}
	public DtoStudent(String st_name, String st_no, String phone_number) {
		this.st_name = st_name;
		this.st_no = st_no;
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "DtoStudent [st_name=" + st_name + ", st_no=" + st_no + ", phone_number=" + phone_number + "]";
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_no() {
		return st_no;
	}
	public void setSt_no(String st_no) {
		this.st_no = st_no;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
