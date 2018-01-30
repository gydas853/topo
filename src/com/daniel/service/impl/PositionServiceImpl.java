package com.daniel.service.impl;

import com.daniel.dao.PositionMapper;
import com.daniel.model.Position;
import com.daniel.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Service("PositionService")
public class PositionServiceImpl implements PositionService{

    @Resource
    private PositionMapper positionMapper;

    @Override
    public boolean addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public boolean updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public boolean deletePosition(Position position) {
        return positionMapper.deletePosition(position);
    }

    @Override
    public List<Position> listAll() {
        return positionMapper.listAll();
    }

    @Override
    public Position getPositionById(Position position) {
        return positionMapper.getPositionById(position);
    }
}
