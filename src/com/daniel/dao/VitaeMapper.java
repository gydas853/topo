package com.daniel.dao;

import com.daniel.model.Vitae;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface VitaeMapper {
    boolean addVitae(Vitae vitae);//���һ������
    boolean updateVitae(Vitae vitae);//�޸ļ���
    boolean deleteVitae(Vitae vitae);//ɾ������
    Vitae getVitaeByV_id(Vitae vitae);//�ҵ�ָ���ļ���-ͨ��������ID
    Vitae getVitaeByG_id(Vitae vitae);//�ҵ�ָ�����û�����-ͨ���ο͵�ID
}
