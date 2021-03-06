package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-28.
 */
public class Company implements Serializable{
    private int c_id;
    private String c_name;
    private String c_companyScale;
    private String c_summary;
    private String c_address;
    private String c_phone;

    public Company() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_companyScale() {
        return c_companyScale;
    }

    public void setC_companyScale(String c_companyScale) {
        this.c_companyScale = c_companyScale;
    }

    public String getC_summary() {
        return c_summary;
    }

    public void setC_summary(String c_summary) {
        this.c_summary = c_summary;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_companyScale='" + c_companyScale + '\'' +
                ", c_summary='" + c_summary + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_phone='" + c_phone + '\'' +
                '}';
    }
}
