package com.daniel.controller;

import com.daniel.model.Guest;
import com.daniel.model.Page;
import com.daniel.model.Recruit;
import com.daniel.model.Vitae;
import com.daniel.service.GuestService;
import com.daniel.service.RecruitService;
import com.daniel.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    /*�ο͵�¼*//*��Ҫ�Ż�*/
    @RequestMapping(value = "/guestLogin",method = RequestMethod.POST)
    public ModelAndView guestLogin(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Guest guest = new Guest();
        guest.setG_name(name);
        guest.setG_pass(pass);

        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            Vitae vitae = new Vitae();
            vitae.setV_g_id(guest1.getG_id());
            /*�鵽���ο����еļ���*/
            List<Vitae> vitaes = vitaeService.getVitaeByG_id(vitae);
            modelAndView.addObject("vitaes",vitaes);
            /*�鵽��վ�ϵ�������Ƹ��Ϣ*/
            List<Recruit> recruits = recruitService.listAll();
            modelAndView.addObject("recruits",recruits);
            /*�û���Ϣ�浽model*/
            HttpSession session = request.getSession();
            session.setAttribute("guest",guest1);
            session.setAttribute("vitaes",vitaes);
            session.setAttribute("recruits",recruits);
            modelAndView.addObject("guest",guest1);
            modelAndView.setViewName("guestMain");
            return modelAndView;
        }else {
            modelAndView.setViewName("main");
            return modelAndView;
        }

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

        List<Vitae> vitaes = vitaeService.getVitaeByG_id(vitae1);
        session.setAttribute("vitaes",vitaes);
        return "guestMain";
    }

    /*�ο�ɾ������*/
    @RequestMapping(value = "/deleteVitae")
    public String deleteVitae(HttpSession session,Vitae vitae)throws Exception{
        vitaeService.deleteVitae(vitae);

        Guest guest = (Guest) session.getAttribute("guest");
        Vitae vitae1 = new Vitae();
        vitae1.setV_g_id(guest.getG_id());

        List<Vitae> vitaes = vitaeService.getVitaeByG_id(vitae1);
        session.setAttribute("vitaes",vitaes);
        return "guestMain";
    }
}
