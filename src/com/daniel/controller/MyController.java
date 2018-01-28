package com.daniel.controller;

import com.daniel.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/*MyController的作用是 把一些比较简单的网页跳转放到一起*/
public class MyController {

    @Resource
    private CompanyService companyService;


    /*跳转到系统界面*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*进入system.jsp*/
        return "system";
    }

    /*使游客访问网页*/
    @RequestMapping(value = "/forMain")
    public String forMain() throws Exception{
        /*进入main.jsp*/
        return "main";
    }

    /*使员工与管理员登录系统*/
    @RequestMapping(value = "/forLogin")
    public String forLogin() throws Exception{
        /*进入员工登录界面 employeeLogin.jsp*/
        return "employeeLogin";
    }
}
