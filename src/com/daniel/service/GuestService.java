package com.daniel.service;

import com.daniel.model.Guest;

/**
 * Created by nero0 on 2018-01-27.
 */
public interface GuestService {
    boolean addGuest(Guest guest);//����һ���ο�
    Guest getGuest(Guest guest);//�ҵ�һ���ο�
    Guest getGuestById(Guest guest);
}
