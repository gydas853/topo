package com.daniel.controller;

import com.daniel.model.Guest;
import com.daniel.model.Offer;
import com.daniel.model.Recruit;
import com.daniel.model.Vitae;
import com.daniel.service.GuestService;
import com.daniel.service.OfferService;
import com.daniel.service.RecruitService;
import com.daniel.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    /*�ο͵�¼*//*�Ż�����*/
    @RequestMapping(value = "/guestLogin",method = RequestMethod.POST)
    public String guestLogin(HttpSession session,Guest guest) throws Exception{
        /*�ҵ��ο���Ϣ*/
        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            Vitae vitae = new Vitae();
            vitae.setV_g_id(guest1.getG_id());
            /*�鵽���ο͵ļ���*/
            Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
            /*�û��ļ����浽session��*/
            session.setAttribute("vitae",vitae1);

            /*�û���Ϣ�浽model*/
            session.setAttribute("guest",guest1);

            return "guestMain";
        }
        return "main";

    }

    /*�ο�ע���Ϊ��Ա*//*��Ҫ�Ż�*/
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

    /*�ο���Ӽ���*/
    @RequestMapping(value = "/addVitae")
    public String addVitae(Vitae vitae) throws Exception{
        vitaeService.addVitae(vitae);
        return "main";
    }

    /*�ο��޸ļ���*/
    @RequestMapping(value = "/changeVitae")
    public String changeVitae(HttpSession session,Vitae vitae) throws Exception{
        vitaeService.updateVitae(vitae);

        Guest guest = (Guest) session.getAttribute("guest");
        Vitae vitae1 = new Vitae();
        vitae1.setV_g_id(guest.getG_id());

        Vitae vitae2 = vitaeService.getVitaeByG_id(vitae1);
        session.setAttribute("vitae",vitae2);
        return "guestMain";
    }

    /*�ο�ɾ������*/
    @RequestMapping(value = "/deleteVitae")
    public String deleteVitae(HttpSession session,Vitae vitae)throws Exception{
        vitaeService.deleteVitae(vitae);

        Guest guest = (Guest) session.getAttribute("guest");
        Vitae vitae1 = new Vitae();
        vitae1.setV_g_id(guest.getG_id());

        Vitae vitae2 = vitaeService.getVitaeByG_id(vitae1);
        session.setAttribute("vitae",vitae2);
        return "guestMain";
    }

    /*�ο�Ͷ����*/
    @RequestMapping(value = "/offerToJob")
    public String offerJob(,Vitae vitae,Recruit recruit) throws Exception{

        Vitae vitae1 = vitaeService.getVitaeByV_id(vitae);
        Recruit recruit1 = recruitService.getRecruitById(recruit);
        Offer offer = new Offer();
        offer.setO_r_id(recruit1.getR_id());
        offer.setO_v_id(vitae1.getV_id());

        offerService.addOffer(offer);

        return "main";
    }
}
