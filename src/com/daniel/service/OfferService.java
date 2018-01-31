package com.daniel.service;

import com.daniel.model.Offer;

/**
 * Created by nero0 on 2018-01-30.
 */
public interface OfferService {
    boolean addOffer(Offer offer);//增加一个
    boolean updateOffer(Offer offer);//更新
    boolean deleteOffer(Offer offer);//删除
    Offer getOfferById(Offer offer);//通过id查找
    Offer getOfferByR_V_id(Offer offer);//通过简历与招聘信息id找一个offer
}
