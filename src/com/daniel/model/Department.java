package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-28.
 */
public class Department implements Serializable{
    private int d_id;
    private String d_name;
    private int d_p_id;
    private Position position;

    public Department() {
    }

    public Department(int d_id, String d_name, int d_p_id, Position position) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_p_id = d_p_id;
        this.position = position;
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

    public int getD_p_id() {
        return d_p_id;
    }

    public void setD_p_id(int d_p_id) {
        this.d_p_id = d_p_id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_p_id=" + d_p_id +
                ", position=" + position +
                '}';
    }
}
