package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-26.
 */
public class Manager implements Serializable{

    private int m_id;
    private String m_name;
    private String m_pass;

    public Manager() {
    }

    public Manager(int m_id, String m_name, String m_pass) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_pass = m_pass;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_pass() {
        return m_pass;
    }

    public void setM_pass(String m_pass) {
        this.m_pass = m_pass;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_pass='" + m_pass + '\'' +
                '}';
    }
}
