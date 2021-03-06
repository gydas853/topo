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
    public List<Position> listAllByP_d_id(Position position) {
        return positionMapper.listAllByP_d_id(position);
    }

    @Override
    public List<Position> listAll() {
        return positionMapper.listAll();
    }

    @Override
    public Position getPositionByP_Id(Position position) {
        return positionMapper.getPositionByP_Id(position);
    }

    @Override
    public Position getPositionByP_name(Position position) {
        return positionMapper.getPositionByP_name(position);
    }
}
