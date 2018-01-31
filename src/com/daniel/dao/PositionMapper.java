package com.daniel.dao;

import com.daniel.model.Position;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface PositionMapper {
    boolean addPosition(Position position);//����һ��ְλ
    boolean updatePosition(Position position);//����ְλ��Ϣ
    boolean deletePosition(Position position);//ɾ��һ��ְλ
    List<Position> listAll();//�г�����ְλ
    Position getPositionById(Position position);//�õ�һ��ְλ��Ϣ
}
