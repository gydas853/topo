package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Controller
public class ManagerController {

    /*����Ա��Դ*/
    @Resource
    private ManagerService managerService;

    @Resource
    private CompanyService companyService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @Resource
    private RecruitService recruitService;

    @Resource
    private VitaeService vitaeService;

    @Resource
    private OfferService offerService;

    /*����Ա��¼*/
    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    public String managerLogin(HttpSession session,Manager manager) throws Exception{

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){

            /*ȫ����˾��Ϣ*/
            List<Company> companies = companyService.listAll();
            session.setAttribute("companies",companies);

            /*ȫ��������Ϣ*/
            List<Department> departments = departmentService.listAll();
            session.setAttribute("departments",departments);

            /*ȫ��ְλ��Ϣ*/
            List<Position> positions = positionService.listAll();
            session.setAttribute("positions",positions);

            /*ȫ����Ƹ��Ϣ*/
            List<Recruit> recruits = recruitService.listAll();
            session.setAttribute("recruits",recruits);

            /*����Ա��Ϣ*/
            session.setAttribute("manager",manager1);
            return "managerMain";
        }else {
            return "managerLogin";
        }
    }

    /*����Ա������Ƹ��Ϣ*//*��Ҫ�Ż�*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpSession session,Recruit recruit) throws Exception{

        recruitService.addRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();

        session.setAttribute("recruits",recruits);
        return "managerMain";
    }

    /*����Ա�޸���Ƹ��Ϣ*/
    @RequestMapping(value = "/changeRecruit",method = RequestMethod.POST)
    public String changeRecruit(HttpSession session,Recruit recruit) throws Exception{

        /*�������ݿ�*/
        recruitService.updateRecruit(recruit);
        /*����session*/
        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);
        return "managerMain";
    }

    /*����Աɾ����Ƹ��Ϣ*/
    @RequestMapping(value = "/deleteRecruit")
    public String deleteRecruit(HttpSession session,Recruit recruit) throws Exception{
        /*ɾ��һ����Ƹ��Ϣ*/
        recruitService.deleteRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);

        return "managerMain";
    }
}
