package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.GuestService;
import com.daniel.service.OfferService;
import com.daniel.service.RecruitService;
import com.daniel.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by nero0 on 2018-01-27.
 */
@Controller
public class GuestController {

    @Resource
    private GuestService guestService;

    @Resource
    private RecruitService recruitService;

    @Resource
    private VitaeService vitaeService;

    @Resource
    private OfferService offerService;

    /*游客登录*//*暂未发现问题*/
    @RequestMapping(value = "/guestLogin",method = RequestMethod.POST)
    public String guestLogin(HttpSession session,Guest guest) throws Exception{
        /*找到游客信息*/
        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            Vitae vitae = new Vitae();
            vitae.setV_g_id(guest1.getG_id());
            /*查到此游客的简历*/
            Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
            /*用户的简历存到session里*/
            session.setAttribute("vitae",vitae1);

            /*用户信息存到session*/
            session.setAttribute("guest",guest1);

            return "guestMain";
        }
        return "main";

    }

    /*游客注册成为会员*//*暂未发现问题*/
    @RequestMapping(value = "/register")
    public String register(Guest guest) throws Exception{

        guestService.addGuest(guest);

        return "main";
    }

    /*游客添加简历*//*暂未发现问题*/
    @RequestMapping(value = "/addVitae")
    public String addVitae(HttpSession session,Vitae vitae) throws Exception{

        vitaeService.addVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guestMain";
    }

    /*游客修改简历*//*暂未发现问题*/
    @RequestMapping(value = "/changeVitae")
    public String changeVitae(HttpSession session,Vitae vitae) throws Exception{
        vitaeService.updateVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByV_id(vitae);
        session.setAttribute("vitae",vitae1);
        return "guestMain";
    }

    /*游客删除简历*//*暂未发现问题*/
    @RequestMapping(value = "/deleteVitae",method = RequestMethod.POST)
    public String deleteVitae(HttpSession session,Vitae vitae)throws Exception{
        vitaeService.deleteVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guestMain";
    }

    /*游客投简历*/
    @RequestMapping(value = "/offerToJob")
    public String offerJob(Vitae vitae,Recruit recruit) throws Exception{

        Vitae vitae1 = vitaeService.getVitaeByV_id(vitae);
        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);
        Offer offer = new Offer();
        offer.setO_r_id(recruit1.getR_id());
        offer.setO_v_id(vitae1.getV_id());

        offerService.addOffer(offer);

        return "main";
    }
}
