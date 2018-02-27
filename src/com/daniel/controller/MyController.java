package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @Resource
    private OfferService offerService;

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
        return "manager/managerLogin";
    }

    /*Ա����¼*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employee/employeeLogin";
    }

    /*ʹ����Աǰ���޸���Ƹ��Ϣҳ��*/
    @RequestMapping(value = "/forChangeRecruit",method = RequestMethod.POST)
    public String forChangeRecruit(HttpSession session,Recruit recruit) throws Exception{

        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);
        session.setAttribute("recruit",recruit1);

        return "manager/changeRecruit";
    }

    /*���ع���Ա������*/
    @RequestMapping(value = "/forManagerMain")
    public String forManagerMain() throws Exception{
        return "manager/managerMain";
    }

    /*ʹ����Աǰ���޸Ĺ�˾��Ϣҳ��*/
    @RequestMapping(value = "/forChangeCompany",method = RequestMethod.POST)
    public String forChangeCompany() throws Exception{

        return "manager/changeCompany";
    }

    /*ʹ����Աǰ���޸Ĳ�����Ϣ����*/
    @RequestMapping(value = "/forChangeDepartment",method = RequestMethod.POST)
    public String forChangeDepartment(HttpSession session,Department department) throws Exception{

        Department department1 = departmentService.getDepartmentByD_id(department);
        session.setAttribute("department",department1);

        return "manager/changeDepartment";
    }

    /*ʹ����Աǰ���޸�ְλ��Ϣ����*/
    @RequestMapping(value = "/forChangePosition",method = RequestMethod.POST)
    public String forChangePosition(HttpSession session, Position position) throws Exception{

        Position position1 = positionService.getPositionByP_Id(position);
        session.setAttribute("position",position1);

        return "manager/changePosition";
    }

    /*ת�������������*/
    @RequestMapping(value = "/forInterview")
    public ModelAndView forInterview(Offer offer) throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        Offer offer1 = offerService.getOfferById(offer);

        modelAndView.addObject("offer",offer1);
        modelAndView.setViewName("manager/doInterview");
        return modelAndView;
    }

    /*��ת����ʾְλ��Ϣ����*/
    @RequestMapping(value = "/showPosition")
    public String showPosition(HttpSession session,Position position) throws Exception{

        Department department = new Department();
        department.setD_id(position.getP_d_id());
        Department department1 = departmentService.getDepartmentByD_id(department);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        session.setAttribute("department",department1);

        return "manager/position";
    }
}
