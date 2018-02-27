package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-29.
 */
public class Position implements Serializable{
    private int p_id;
    private String p_name;
    private int p_number;
    private String p_createTime;
    private int p_d_id;

    public Position() {
    }

    public Position(int p_id, String p_name, int p_number, String p_createTime, int p_d_id) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_number = p_number;
        this.p_createTime = p_createTime;
        this.p_d_id = p_d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_number() {
        return p_number;
    }

    public void setP_number(int p_number) {
        this.p_number = p_number;
    }

    public String getP_createTime() {
        return p_createTime;
    }

    public void setP_createTime(String p_createTime) {
        this.p_createTime = p_createTime;
    }

    public int getP_d_id() {
        return p_d_id;
    }

    public void setP_d_id(int p_d_id) {
        this.p_d_id = p_d_id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_number=" + p_number +
                ", p_createTime='" + p_createTime + '\'' +
                ", p_d_id=" + p_d_id +
                '}';
    }
}
