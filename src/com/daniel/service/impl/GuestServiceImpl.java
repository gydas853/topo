package com.daniel.service.impl;

import com.daniel.dao.GuestMapper;
import com.daniel.model.Guest;
import com.daniel.service.GuestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-27.
 */
@Service("GuestService")
public class GuestServiceImpl implements GuestService{

    @Resource
    private GuestMapper guestMapper;

    @Override
    public boolean addGuest(Guest guest) {
        return guestMapper.addGuest(guest);
    }

    @Override
    public Guest getGuest(Guest guest) {
        return guestMapper.getGuest(guest);
    }
}
