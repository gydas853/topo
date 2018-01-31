package com.daniel.dao;

import com.daniel.model.Vitae;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface VitaeMapper {
    boolean addVitae(Vitae vitae);//添加一个简历
    boolean updateVitae(Vitae vitae);//修改简历
    boolean deleteVitae(Vitae vitae);//删除简历
    Vitae getVitaeByV_id(Vitae vitae);//找到指定的简历-通过简历的ID
    Vitae getVitaeByG_id(Vitae vitae);//找到指定的用户简历-通过游客的ID
}
