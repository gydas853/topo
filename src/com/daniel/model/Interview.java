package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-02-13.
 */
public class Interview implements Serializable{
    private int i_id;
    private String i_r_name;
    private String i_v_name;
    private String i_c_name;
    private String i_d_name;
    private String i_p_name;
    private String i_interviewTime;
    private String i_interviewAddress;
    private int i_r_id;
    private int i_g_id;
    private int i_result;

    public Interview() {
    }

    public Interview(int i_id, String i_r_name, String i_v_name, String i_c_name, String i_d_name, String i_p_name, String i_interviewTime, String i_interviewAddress, int i_r_id, int i_g_id, int i_result) {
        this.i_id = i_id;
        this.i_r_name = i_r_name;
        this.i_v_name = i_v_name;
        this.i_c_name = i_c_name;
        this.i_d_name = i_d_name;
        this.i_p_name = i_p_name;
        this.i_interviewTime = i_interviewTime;
        this.i_interviewAddress = i_interviewAddress;
        this.i_r_id = i_r_id;
        this.i_g_id = i_g_id;
        this.i_result = i_result;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public String getI_r_name() {
        return i_r_name;
    }

    public void setI_r_name(String i_r_name) {
        this.i_r_name = i_r_name;
    }

    public String getI_v_name() {
        return i_v_name;
    }

    public void setI_v_name(String i_v_name) {
        this.i_v_name = i_v_name;
    }

    public String getI_c_name() {
        return i_c_name;
    }

    public void setI_c_name(String i_c_name) {
        this.i_c_name = i_c_name;
    }

    public String getI_d_name() {
        return i_d_name;
    }

    public void setI_d_name(String i_d_name) {
        this.i_d_name = i_d_name;
    }

    public String getI_p_name() {
        return i_p_name;
    }

    public void setI_p_name(String i_p_name) {
        this.i_p_name = i_p_name;
    }

    public String getI_interviewTime() {
        return i_interviewTime;
    }

    public void setI_interviewTime(String i_interviewTime) {
        this.i_interviewTime = i_interviewTime;
    }

    public String getI_interviewAddress() {
        return i_interviewAddress;
    }

    public void setI_interviewAddress(String i_interviewAddress) {
        this.i_interviewAddress = i_interviewAddress;
    }

    public int getI_r_id() {
        return i_r_id;
    }

    public void setI_r_id(int i_r_id) {
        this.i_r_id = i_r_id;
    }

    public int getI_g_id() {
        return i_g_id;
    }

    public void setI_g_id(int i_g_id) {
        this.i_g_id = i_g_id;
    }

    public int getI_result() {
        return i_result;
    }

    public void setI_result(int i_result) {
        this.i_result = i_result;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", i_r_name='" + i_r_name + '\'' +
                ", i_v_name='" + i_v_name + '\'' +
                ", i_c_name='" + i_c_name + '\'' +
                ", i_d_name='" + i_d_name + '\'' +
                ", i_p_name='" + i_p_name + '\'' +
                ", i_interviewTime='" + i_interviewTime + '\'' +
                ", i_interviewAddress='" + i_interviewAddress + '\'' +
                ", i_r_id=" + i_r_id +
                ", i_g_id=" + i_g_id +
                ", i_result=" + i_result +
                '}';
    }
}

