package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-29.
 */
public class Position implements Serializable{
    private int p_id;
    private String p_name;
    private Recruit recruit;

    public Position() {
    }

    public Position(int p_id, String p_name) {
        this.p_id = p_id;
        this.p_name = p_name;
    }

    public Position(int p_id, String p_name, Recruit recruit) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.recruit = recruit;
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

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    @Override
    public String toString() {
        return "Position{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                '}';
    }
}
