package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-02-22.
 */
public class Employee implements Serializable{
    private int e_id;
    private String e_name;
    private String e_pass;
    private String e_trueName;
    private int e_age;
    private String e_phone;
    private String e_email;
    private double e_salary;
    private String e_department;
    private String e_position;
    private String e_training;
    private String e_state;

    public Employee() {
    }

    public Employee(int e_id, String e_name, String e_pass, String e_trueName, int e_age, String e_phone, String e_email, double e_salary, String e_department, String e_position, String e_training, String e_state) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_pass = e_pass;
        this.e_trueName = e_trueName;
        this.e_age = e_age;
        this.e_phone = e_phone;
        this.e_email = e_email;
        this.e_salary = e_salary;
        this.e_department = e_department;
        this.e_position = e_position;
        this.e_training = e_training;
        this.e_state = e_state;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public String getE_trueName() {
        return e_trueName;
    }

    public void setE_trueName(String e_trueName) {
        this.e_trueName = e_trueName;
    }

    public int getE_age() {
        return e_age;
    }

    public void setE_age(int e_age) {
        this.e_age = e_age;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public double getE_salary() {
        return e_salary;
    }

    public void setE_salary(double e_salary) {
        this.e_salary = e_salary;
    }

    public String getE_department() {
        return e_department;
    }

    public void setE_department(String e_department) {
        this.e_department = e_department;
    }

    public String getE_position() {
        return e_position;
    }

    public void setE_position(String e_position) {
        this.e_position = e_position;
    }

    public String getE_training() {
        return e_training;
    }

    public void setE_training(String e_training) {
        this.e_training = e_training;
    }

    public String getE_state() {
        return e_state;
    }

    public void setE_state(String e_state) {
        this.e_state = e_state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_pass='" + e_pass + '\'' +
                ", e_trueName='" + e_trueName + '\'' +
                ", e_age=" + e_age +
                ", e_phone='" + e_phone + '\'' +
                ", e_email='" + e_email + '\'' +
                ", e_salary=" + e_salary +
                ", e_department='" + e_department + '\'' +
                ", e_position='" + e_position + '\'' +
                ", e_training='" + e_training + '\'' +
                ", e_state='" + e_state + '\'' +
                '}';
    }
}
