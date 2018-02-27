package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-28.
 */
public class Department implements Serializable{
    private int d_id;
    private String d_name;
    private int d_number;
    private String d_createTime;

    public Department() {
    }

    public Department(int d_id, String d_name, int d_number, String d_createTime) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_number = d_number;
        this.d_createTime = d_createTime;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public int getD_number() {
        return d_number;
    }

    public void setD_number(int d_number) {
        this.d_number = d_number;
    }

    public String getD_createTime() {
        return d_createTime;
    }

    public void setD_createTime(String d_createTime) {
        this.d_createTime = d_createTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_number=" + d_number +
                ", d_createTime='" + d_createTime + '\'' +
                '}';
    }
}
