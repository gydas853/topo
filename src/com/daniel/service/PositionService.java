package com.daniel.service;

import com.daniel.model.Position;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface PositionService {
    boolean addPosition(Position position);//����һ��ְλ
    boolean updatePosition(Position position);//����ְλ��Ϣ
    boolean deletePosition(Position position);//ɾ��һ��ְλ
    List<Position> listAllByP_d_id(Position position);//�г�����ְλ
    List<Position> listAll();
    Position getPositionByP_Id(Position position);//�õ�һ��ְλ��Ϣ
    Position getPositionByP_name(Position position);
}
