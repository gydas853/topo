package com.daniel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/*MyController�������� ��һЩ�Ƚϼ򵥵���ҳ��ת�ŵ�һ��*/
public class MyController {

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
        return "guestMain";
    }

    /*ʹԱ�������Ա��¼ϵͳ*/
    @RequestMapping(value = "/forLogin")
    public String forLogin() throws Exception{
        /*����Ա����¼���� employeeLogin.jsp*/
        return "employeeLogin";
    }
}
