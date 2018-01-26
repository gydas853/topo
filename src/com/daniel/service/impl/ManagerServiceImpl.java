package com.daniel.service.impl;

import com.daniel.dao.ManagerMapper;
import com.daniel.model.Manager;
import com.daniel.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-26.
 */
@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager getManager(Manager manager) {
        return managerMapper.getManager(manager);
    }
}
