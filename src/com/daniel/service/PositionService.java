package com.daniel.service;

import com.daniel.model.Position;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface PositionService {
    boolean addPosition(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Position position);
    List<Position> listAll();
    Position getPosition(Position position);
}
