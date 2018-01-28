package com.daniel.controller;

import com.daniel.model.Guest;
import com.daniel.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by nero0 on 2018-01-27.
 */
@Controller
public class GuestController {

    @Resource
    private GuestService guestService;

    @RequestMapping(value = "/guestLogin")
    public ModelAndView guestLogin(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Guest guest = new Guest();
        guest.setG_name(name);
        guest.setG_pass(pass);

        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            modelAndView.addObject("guest",guest1);
            modelAndView.setViewName("guestMain");
            return modelAndView;
        }else {
            modelAndView.setViewName("main");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Guest guest = new Guest();
        guest.setG_name(name);
        guest.setG_pass(pass);

        guestService.addGuest(guest);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
