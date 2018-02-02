package com.daniel.controller;

import com.daniel.model.Company;
import com.daniel.model.Department;
import com.daniel.model.Position;
import com.daniel.model.Recruit;
import com.daniel.service.CompanyService;
import com.daniel.service.DepartmentService;
import com.daniel.service.PositionService;
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
    public String forMain(HttpSession session) throws Exception{
        /*�鵽���е���Ƹ��Ϣ*/
        List<Recruit> recruits = recruitService.listAll();
        /*session���鵽����Ƹ��Ϣ*/
        session.setAttribute("recruits",recruits);
        /*��ת��mainҳ��*/
        return "main";
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

    /*ʹ����Աǰ���޸���Ƹ��Ϣҳ��*/
    @RequestMapping(value = "/forChangeRecruit")
    public String forChangeRecruit(HttpSession session,Recruit recruit) throws Exception{

        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);
        session.setAttribute("recruit",recruit1);

        return "changeRecruit";
    }
}
