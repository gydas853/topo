package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-28.
 */
public class Department implements Serializable{
    private int d_id;
    private String d_name;

    public Department() {
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

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                '}';
    }
}
