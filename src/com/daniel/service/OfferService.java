package com.daniel.service;

import com.daniel.model.Offer;

/**
 * Created by nero0 on 2018-01-30.
 */
public interface OfferService {
    boolean addOffer(Offer offer);//����һ��
    boolean updateOffer(Offer offer);//����
    boolean deleteOffer(Offer offer);//ɾ��
    Offer getOfferById(Offer offer);//ͨ��id����
    Offer getOfferByR_V_id(Offer offer);//ͨ����������Ƹ��Ϣid��һ��offer
}
