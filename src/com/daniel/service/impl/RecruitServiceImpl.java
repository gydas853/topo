package com.daniel.service.impl;

import com.daniel.dao.RecruitMapper;
import com.daniel.model.Recruit;
import com.daniel.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Service("RecruitService")
public class RecruitServiceImpl implements RecruitService{

    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public boolean addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        return recruitMapper.updateRecruit(recruit);
    }

    @Override
    public boolean deleteRecruit(Recruit recruit) {
        return recruitMapper.deleteRecruit(recruit);
    }

    @Override
    public List<Recruit> listAll() {
        List<Recruit> recruits = recruitMapper.listAll();
        if(null != recruits){
            return recruits;
        }
        return null;
    }

    @Override
    public Recruit getRecruitByR_id(Recruit recruit) {
        Recruit recruit1 = recruitMapper.getRecruitByR_id(recruit);
        if(null != recruit1){
            return recruit1;
        }
        return null;
    }
}
