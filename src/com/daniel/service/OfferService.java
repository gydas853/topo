package com.daniel.service;

import com.daniel.model.Offer;

import java.util.List;

/**
 * Created by nero0 on 2018-01-30.
 */
public interface OfferService {
    boolean addOffer(Offer offer);//增加一个
    boolean updateOffer(Offer offer);//更新
    boolean deleteOffer(Offer offer);//删除
    Offer getOneByR_idAndG_id(Offer offer);
    Offer getOfferById(Offer offer);//通过id查找
    List<Offer> listAllState_0();
}
