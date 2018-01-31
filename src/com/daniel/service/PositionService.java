package com.daniel.service;

import com.daniel.model.Position;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface PositionService {
    boolean addPosition(Position position);//增加一个职位
    boolean updatePosition(Position position);//更新职位信息
    boolean deletePosition(Position position);//删除一个职位
    List<Position> listAll();//列出所有职位
    Position getPositionById(Position position);//拿到一个职位信息
}
