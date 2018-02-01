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
    private int r_d_id;
    private int r_p_id;
    /*四表联合查询*/
    private Company company;
    private Department department;
    private Position position;

    public Recruit() {
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

    public int getR_d_id() {
        return r_d_id;
    }

    public void setR_d_id(int r_d_id) {
        this.r_d_id = r_d_id;
    }

    public int getR_p_id() {
        return r_p_id;
    }

    public void setR_p_id(int r_p_id) {
        this.r_p_id = r_p_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_money='" + r_money + '\'' +
                ", r_c_id=" + r_c_id +
                ", r_d_id=" + r_d_id +
                ", r_p_id=" + r_p_id +
                ", company=" + company +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
