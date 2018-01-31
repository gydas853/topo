package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-29.
 */
public class Recruit implements Serializable{
    private int r_id;
    private String r_name;
    private String r_money;
    private int r_c_id;
    private Company company;

    public Recruit() {
    }

    public Recruit(int r_id, String r_name, String r_money, int r_c_id, Company company) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_money = r_money;
        this.r_c_id = r_c_id;
        this.company = company;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_money() {
        return r_money;
    }

    public void setR_money(String r_money) {
        this.r_money = r_money;
    }

    public int getR_c_id() {
        return r_c_id;
    }

    public void setR_c_id(int r_c_id) {
        this.r_c_id = r_c_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_money='" + r_money + '\'' +
                ", r_c_id=" + r_c_id +
                ", company=" + company +
                '}';
    }
}
