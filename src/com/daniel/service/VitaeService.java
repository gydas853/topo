package com.daniel.service;

import com.daniel.model.Vitae;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface VitaeService {
    boolean addVitae(Vitae vitae);
    boolean updateVitae(Vitae vitae);
    boolean deleteVitae(Vitae vitae);
    List<Vitae> listAll();
    Vitae getVitaeById(Vitae vitae);
    List<Vitae> getVitaeByG_id(Vitae vitae);
}
