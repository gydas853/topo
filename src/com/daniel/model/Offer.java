package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-30.
 */
public class Offer implements Serializable{
    private int o_id;
    private int o_r_id;
    private int o_v_id;

    public Offer() {
    }

    public Offer(int o_id, int o_r_id, int o_v_id) {
        this.o_id = o_id;
        this.o_r_id = o_r_id;
        this.o_v_id = o_v_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getO_r_id() {
        return o_r_id;
    }

    public void setO_r_id(int o_r_id) {
        this.o_r_id = o_r_id;
    }

    public int getO_v_id() {
        return o_v_id;
    }

    public void setO_v_id(int o_v_id) {
        this.o_v_id = o_v_id;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "o_id=" + o_id +
                ", o_r_id=" + o_r_id +
                ", o_v_id=" + o_v_id +
                '}';
    }
}
