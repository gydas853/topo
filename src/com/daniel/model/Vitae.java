package com.daniel.model;

import java.io.Serializable;

/**
 * Created by nero0 on 2018-01-29.
 */
public class Vitae implements Serializable{
    private int v_id;
    private String v_name;
    private String v_sex;
    private String v_birth;
    private String v_ethnicity;
    private String v_nativePlace;
    private String v_qualification;
    private String v_tel;
    private String v_email;
    private String v_specialty;
    private String v_serviceYear;
    private String v_willSpot;
    private String v_adsumDate;
    private String v_promisingIndustry;
    private int v_g_id;

    public Vitae() {
    }

    public Vitae(int v_id, String v_name, String v_sex, String v_birth, String v_ethnicity, String v_nativePlace, String v_qualification, String v_tel, String v_email, String v_specialty, String v_serviceYear, String v_willSpot, String v_adsumDate, String v_promisingIndustry) {
        this.v_id = v_id;
        this.v_name = v_name;
        this.v_sex = v_sex;
        this.v_birth = v_birth;
        this.v_ethnicity = v_ethnicity;
        this.v_nativePlace = v_nativePlace;
        this.v_qualification = v_qualification;
        this.v_tel = v_tel;
        this.v_email = v_email;
        this.v_specialty = v_specialty;
        this.v_serviceYear = v_serviceYear;
        this.v_willSpot = v_willSpot;
        this.v_adsumDate = v_adsumDate;
        this.v_promisingIndustry = v_promisingIndustry;
    }

    public Vitae(int v_id, String v_name, String v_sex, String v_birth, String v_ethnicity, String v_nativePlace, String v_qualification, String v_tel, String v_email, String v_specialty, String v_serviceYear, String v_willSpot, String v_adsumDate, String v_promisingIndustry, int v_g_id) {
        this.v_id = v_id;
        this.v_name = v_name;
        this.v_sex = v_sex;
        this.v_birth = v_birth;
        this.v_ethnicity = v_ethnicity;
        this.v_nativePlace = v_nativePlace;
        this.v_qualification = v_qualification;
        this.v_tel = v_tel;
        this.v_email = v_email;
        this.v_specialty = v_specialty;
        this.v_serviceYear = v_serviceYear;
        this.v_willSpot = v_willSpot;
        this.v_adsumDate = v_adsumDate;
        this.v_promisingIndustry = v_promisingIndustry;
        this.v_g_id = v_g_id;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_sex() {
        return v_sex;
    }

    public void setV_sex(String v_sex) {
        this.v_sex = v_sex;
    }

    public String getV_birth() {
        return v_birth;
    }

    public void setV_birth(String v_birth) {
        this.v_birth = v_birth;
    }

    public String getV_ethnicity() {
        return v_ethnicity;
    }

    public void setV_ethnicity(String v_ethnicity) {
        this.v_ethnicity = v_ethnicity;
    }

    public String getV_nativePlace() {
        return v_nativePlace;
    }

    public void setV_nativePlace(String v_nativePlace) {
        this.v_nativePlace = v_nativePlace;
    }

    public String getV_qualification() {
        return v_qualification;
    }

    public void setV_qualification(String v_qualification) {
        this.v_qualification = v_qualification;
    }

    public String getV_tel() {
        return v_tel;
    }

    public void setV_tel(String v_tel) {
        this.v_tel = v_tel;
    }

    public String getV_email() {
        return v_email;
    }

    public void setV_email(String v_email) {
        this.v_email = v_email;
    }

    public String getV_specialty() {
        return v_specialty;
    }

    public void setV_specialty(String v_specialty) {
        this.v_specialty = v_specialty;
    }

    public String getV_serviceYear() {
        return v_serviceYear;
    }

    public void setV_serviceYear(String v_serviceYear) {
        this.v_serviceYear = v_serviceYear;
    }

    public String getV_willSpot() {
        return v_willSpot;
    }

    public void setV_willSpot(String v_willSpot) {
        this.v_willSpot = v_willSpot;
    }

    public String getV_adsumDate() {
        return v_adsumDate;
    }

    public void setV_adsumDate(String v_adsumDate) {
        this.v_adsumDate = v_adsumDate;
    }

    public String getV_promisingIndustry() {
        return v_promisingIndustry;
    }

    public void setV_promisingIndustry(String v_promisingIndustry) {
        this.v_promisingIndustry = v_promisingIndustry;
    }

    public int getV_g_id() {
        return v_g_id;
    }

    public void setV_g_id(int v_g_id) {
        this.v_g_id = v_g_id;
    }

    @Override
    public String toString() {
        return "Vitae{" +
                "v_id=" + v_id +
                ", v_name='" + v_name + '\'' +
                ", v_sex='" + v_sex + '\'' +
                ", v_birth='" + v_birth + '\'' +
                ", v_ethnicity='" + v_ethnicity + '\'' +
                ", v_nativePlace='" + v_nativePlace + '\'' +
                ", v_qualification='" + v_qualification + '\'' +
                ", v_tel='" + v_tel + '\'' +
                ", v_email='" + v_email + '\'' +
                ", v_specialty='" + v_specialty + '\'' +
                ", v_serviceYear='" + v_serviceYear + '\'' +
                ", v_willSpot='" + v_willSpot + '\'' +
                ", v_adsumDate='" + v_adsumDate + '\'' +
                ", v_promisingIndustry='" + v_promisingIndustry + '\'' +
                ", v_c_id=" + v_g_id +
                '}';
    }
}
