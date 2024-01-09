package com.sugang.dto;

public class DtoSugang {
    private String st_no;
    private String class_no;
    private int class_credit;

    public DtoSugang() {
    }

    public DtoSugang(String st_no, String class_no, int class_credit) {
        this.st_no = st_no;
        this.class_no = class_no;
        this.class_credit = class_credit;
    }

    @Override
    public String toString() {
        return "DtoSugang [st_no=" + st_no + ", class_no=" + class_no + ", class_credit=" + class_credit + "]";
    }

    public int getClass_credit() {
        return class_credit;
    }

    public void setClass_credit(int class_credit) {
        this.class_credit = class_credit;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getSt_no() {
        return st_no;
    }

    public void setSt_no(String st_no) {
        this.st_no = st_no;
    }

}
