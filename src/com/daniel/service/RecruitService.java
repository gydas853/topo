package com.daniel.service;

import com.daniel.model.Recruit;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface RecruitService {
    boolean addRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    boolean deleteRecruit(Recruit recruit);
    List<Recruit> listAll();
    Recruit getRecruitById(Recruit recruit);
}
