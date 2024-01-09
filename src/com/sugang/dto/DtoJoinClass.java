package com.sugang.dto;

public class DtoJoinClass {
    private String class_name;
    private String class_no;
    private String student_no;

    public DtoJoinClass() {
    }

    public DtoJoinClass(String class_name, String class_no, String student_no) {
        super();
        this.class_name = class_name;
        this.class_no = class_no;
        this.student_no = student_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    @Override
    public String toString() {
        return "DtoJoinClass [class_name=" + class_name + ", class_no=" + class_no + ", student_no=" + student_no + "]";
    }

}
