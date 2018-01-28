package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-27.
 */
public class Guest implements Serializable{

    private int g_id;
    private String g_name;
    private String g_pass;

    public Guest() {
    }

    public Guest(int g_id, String g_name, String g_pass) {
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_pass = g_pass;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_pass() {
        return g_pass;
    }

    public void setG_pass(String g_pass) {
        this.g_pass = g_pass;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "g_id=" + g_id +
                ", g_name='" + g_name + '\'' +
                ", g_pass='" + g_pass + '\'' +
                '}';
    }
}
