package com.daniel.dao;

import com.daniel.model.Vitae;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface VitaeMapper {
    boolean addVitae(Vitae vitae);//���һ������
    boolean updateVitae(Vitae vitae);//�޸ļ���
    boolean deleteVitae(Vitae vitae);//ɾ������
    List<Vitae> listAll();//�ҵ����еļ���
    Vitae getVitaeById(Vitae vitae);//�ҵ�ָ�����û�����-ͨ��������ID
    List<Vitae> getVitaeByG_id(Vitae vitae);//�ҵ��û����еļ���
}
