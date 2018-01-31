package com.daniel.dao;

import com.daniel.model.Recruit;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface RecruitMapper {
    boolean addRecruit(Recruit recruit);//����һ����Ƹ��Ϣ
    boolean updateRecruit(Recruit recruit);//������Ƹ��Ϣ����
    boolean deleteRecruit(Recruit recruit);//ɾ��һ����Ƹ��Ϣ
    List<Recruit> listAll();//�г�������Ƹ��Ϣ
    Recruit getRecruitByR_id(Recruit recruit);//�ҵ�һ����Ƹ��Ϣ
}
