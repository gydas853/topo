package com.daniel.dao;

import com.daniel.model.Recruit;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface RecruitMapper {
    boolean addRecruit(Recruit recruit);//增加一个招聘信息
    boolean updateRecruit(Recruit recruit);//更新招聘信息数据
    boolean deleteRecruit(Recruit recruit);//删除一个招聘信息
    List<Recruit> listAll();//列出所有招聘信息
    Recruit getRecruitByR_id(Recruit recruit);//找到一个招聘信息
}
