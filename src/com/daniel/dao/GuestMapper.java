package com.daniel.dao;

import com.daniel.model.Guest;

/**
 * Created by nero0 on 2018-01-27.
 */
public interface GuestMapper {
    boolean addGuest(Guest guest);//增加一个游客
    Guest getGuest(Guest guest);//找到一个游客
}
