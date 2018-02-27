package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-30.
 */
public class Offer implements Serializable{
    private int o_id;
    private String o_v_name;
    private int o_r_id;
    private int o_g_id;
    private int o_state;
    /*三表联合查询*/
    private Recruit recruit;
    private Vitae vitae;

    public Offer() {
    }

    public Offer(int o_id, String o_v_name, int o_r_id, int o_g_id, int o_state, Recruit recruit, Vitae vitae) {
        this.o_id = o_id;
        this.o_v_name = o_v_name;
        this.o_r_id = o_r_id;
        this.o_g_id = o_g_id;
        this.o_state = o_state;
        this.recruit = recruit;
        this.vitae = vitae;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_v_name() {
        return o_v_name;
    }

    public void setO_v_name(String o_v_name) {
        this.o_v_name = o_v_name;
    }

    public int getO_r_id() {
        return o_r_id;
    }

    public void setO_r_id(int o_r_id) {
        this.o_r_id = o_r_id;
    }

    public int getO_g_id() {
        return o_g_id;
    }

    public void setO_g_id(int o_g_id) {
        this.o_g_id = o_g_id;
    }

    public int getO_state() {
        return o_state;
    }

    public void setO_state(int o_state) {
        this.o_state = o_state;
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    public Vitae getVitae() {
        return vitae;
    }

    public void setVitae(Vitae vitae) {
        this.vitae = vitae;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "o_id=" + o_id +
                ", o_v_name='" + o_v_name + '\'' +
                ", o_r_id=" + o_r_id +
                ", o_g_id=" + o_g_id +
                ", o_state=" + o_state +
                ", recruit=" + recruit +
                ", vitae=" + vitae +
                '}';
    }
}
