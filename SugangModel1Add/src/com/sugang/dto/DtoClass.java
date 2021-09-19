package com.sugang.dto;

public class DtoClass {
	private String class_no;
	private String class_name;
	private String class_content;
	public DtoClass() {}
	public DtoClass(String class_no,String class_name, String class_content) {
		this.class_no = class_no;
		this.class_name = class_name;
		this.class_content = class_content;
	}
	@Override
	public String toString() {
		return "DtoClass [class_no=" + class_no + ", class_name=" + class_name + ", class_content=" + class_content
				+ "]";
	}
	public String getClass_no() {
		return class_no;
	}
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_content() {
		return class_content;
	}
	public void setClass_content(String class_content) {
		this.class_content = class_content;
	}

	

}
