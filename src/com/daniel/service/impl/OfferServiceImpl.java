package com.daniel.service.impl;

import com.daniel.dao.OfferMapper;
import com.daniel.model.Offer;
import com.daniel.service.OfferService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-30.
 */
@Service("OfferService")
public class OfferServiceImpl implements OfferService{

    @Resource
    private OfferMapper offerMapper;

    @Override
    public boolean addOffer(Offer offer) {
        return offerMapper.addOffer(offer);
    }

    @Override
    public boolean updateOffer(Offer offer) {
        return offerMapper.updateOffer(offer);
    }

    @Override
    public boolean deleteOffer(Offer offer) {
        return offerMapper.deleteOffer(offer);
    }

    @Override
    public Offer getOfferById(Offer offer) {
        return offerMapper.getOfferById(offer);
    }

    @Override
    public Offer getOfferByR_V_id(Offer offer) {
        return offerMapper.getOfferByR_V_id(offer);
    }
}
