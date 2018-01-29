package com.daniel.dao;

import com.daniel.model.Vitae;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface VitaeMapper {
    boolean addVitae(Vitae vitae);//添加一个简历
    boolean updateVitae(Vitae vitae);//修改简历
    boolean deleteVitae(Vitae vitae);//删除简历
    List<Vitae> listAll();//找到所有的简历
    Vitae getVitaeById(Vitae vitae);//找到指定的用户简历-通过简历的ID
    List<Vitae> getVitaeByG_id(Vitae vitae);//找到用户所有的简历
}
