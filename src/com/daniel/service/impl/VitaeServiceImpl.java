package com.daniel.service.impl;

import com.daniel.dao.VitaeMapper;
import com.daniel.model.Vitae;
import com.daniel.service.VitaeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Service("VitaeService")
public class VitaeServiceImpl implements VitaeService{

    @Resource
    private VitaeMapper vitaeMapper;

    @Override
    public boolean addVitae(Vitae vitae) {
        return vitaeMapper.addVitae(vitae);
    }

    @Override
    public boolean updateVitae(Vitae vitae) {
        return vitaeMapper.updateVitae(vitae);
    }

    @Override
    public boolean deleteVitae(Vitae vitae) {
        return vitaeMapper.deleteVitae(vitae);
    }

    @Override
    public List<Vitae> listAll() {
        return vitaeMapper.listAll();
    }

    @Override
    public Vitae getVitaeById(Vitae vitae) {
        return vitaeMapper.getVitaeById(vitae);
    }

    @Override
    public List<Vitae> getVitaeByG_id(Vitae vitae) {
        return vitaeMapper.getVitaeByG_id(vitae);
    }

}
