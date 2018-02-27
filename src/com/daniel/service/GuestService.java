package com.daniel.service;

import com.daniel.model.Guest;

/**
 * Created by nero0 on 2018-01-27.
 */
public interface GuestService {
    boolean addGuest(Guest guest);//增加一个游客
    Guest getGuest(Guest guest);//找到一个游客
    Guest getGuestById(Guest guest);
}
