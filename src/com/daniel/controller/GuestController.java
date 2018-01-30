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

    /*游客登录*//*需要优化*/
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
            /*查到此游客所有的简历*/
            List<Vitae> vitaes = vitaeService.getVitaeByG_id(vitae);
            modelAndView.addObject("vitaes",vitaes);
            /*查到网站上的所有招聘信息*/
            List<Recruit> recruits = recruitService.listAll();
            modelAndView.addObject("recruits",recruits);
            /*用户信息存到model*/
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

    /*游客注册成为会员*//*需要优化*/
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

    /*游客添加简历*/
    @RequestMapping(value = "/addVitae")
    public String addVitae(Vitae vitae) throws Exception{
        vitaeService.addVitae(vitae);
        return "main";
    }

    /*游客修改简历*/
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

    /*游客删除简历*/
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
