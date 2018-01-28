package com.daniel.controller;

import com.daniel.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/*MyController�������� ��һЩ�Ƚϼ򵥵���ҳ��ת�ŵ�һ��*/
public class MyController {

    @Resource
    private CompanyService companyService;


    /*��ת��ϵͳ����*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*����system.jsp*/
        return "system";
    }

    /*ʹ�οͷ�����ҳ*/
    @RequestMapping(value = "/forMain")
    public String forMain() throws Exception{
        /*����main.jsp*/
        return "main";
    }

    /*ʹԱ�������Ա��¼ϵͳ*/
    @RequestMapping(value = "/forLogin")
    public String forLogin() throws Exception{
        /*����Ա����¼���� employeeLogin.jsp*/
        return "employeeLogin";
    }
}
