package com.daniel.controller;

import com.daniel.model.Recruit;
import com.daniel.service.CompanyService;
import com.daniel.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/*MyController�������� ��һЩ�Ƚϼ򵥵���ҳ��ת�ŵ�һ��*/
public class MyController {

    @Resource
    private RecruitService recruitService;


    /*��ת��ϵͳ����*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*����system.jsp*/
        return "system";
    }

    /*ʹ�οͷ�����ҳ*/
    @RequestMapping(value = "/forMain")
    public ModelAndView forMain() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Recruit> recruits = recruitService.listAll();
        modelAndView.addObject("recruits",recruits);
        modelAndView.setViewName("main");
        /*����main.jsp*/
        return modelAndView;
    }

    /*����Ա��¼ϵͳ*/
    @RequestMapping(value = "/forManagerLogin")
    public String forLogin() throws Exception{
        /*�������Ա��¼����*/
        return "managerLogin";
    }

    /*Ա����¼*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employeeLogin";
    }
}
