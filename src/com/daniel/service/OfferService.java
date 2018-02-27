package com.daniel.service;

import com.daniel.model.Offer;

import java.util.List;

/**
 * Created by nero0 on 2018-01-30.
 */
public interface OfferService {
    boolean addOffer(Offer offer);//����һ��
    boolean updateOffer(Offer offer);//����
    boolean deleteOffer(Offer offer);//ɾ��
    Offer getOneByR_idAndG_id(Offer offer);
    Offer getOfferById(Offer offer);//ͨ��id����
    List<Offer> listAllState_0();
}
