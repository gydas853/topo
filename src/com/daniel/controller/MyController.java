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
/*MyController的作用是 把一些比较简单的网页跳转放到一起*/
public class MyController {

    @Resource
    private RecruitService recruitService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @Resource
    private OfferService offerService;

    /*跳转到系统界面*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*进入system.jsp*/
        return "system";
    }

    /*使游客访问网页*/
    @RequestMapping(value = "/forMain")
    public String forMain(HttpSession session) throws Exception{
        /*查到所有的招聘信息*/
        List<Recruit> recruits = recruitService.listAll();
        /*session里存查到的招聘信息*/
        session.setAttribute("recruits",recruits);
        /*跳转到main页面*/
        return "main";
    }

    /*管理员登录系统*/
    @RequestMapping(value = "/forManagerLogin")
    public String forLogin() throws Exception{
        /*进入管理员登录界面*/
        return "manager/managerLogin";
    }

    /*员工登录*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employee/employeeLogin";
    }

    /*使管理员前往修改招聘信息页面*/
    @RequestMapping(value = "/forChangeRecruit",method = RequestMethod.POST)
    public String forChangeRecruit(HttpSession session,Recruit recruit) throws Exception{

        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);
        session.setAttribute("recruit",recruit1);

        return "manager/changeRecruit";
    }

    /*返回管理员主界面*/
    @RequestMapping(value = "/forManagerMain")
    public String forManagerMain() throws Exception{
        return "manager/managerMain";
    }

    /*使管理员前往修改公司信息页面*/
    @RequestMapping(value = "/forChangeCompany",method = RequestMethod.POST)
    public String forChangeCompany() throws Exception{

        return "manager/changeCompany";
    }

    /*使管理员前往修改部门信息界面*/
    @RequestMapping(value = "/forChangeDepartment",method = RequestMethod.POST)
    public String forChangeDepartment(HttpSession session,Department department) throws Exception{

        Department department1 = departmentService.getDepartmentByD_id(department);
        session.setAttribute("department",department1);

        return "manager/changeDepartment";
    }

    /*使管理员前往修改职位信息界面*/
    @RequestMapping(value = "/forChangePosition",method = RequestMethod.POST)
    public String forChangePosition(HttpSession session, Position position) throws Exception{

        Position position1 = positionService.getPositionByP_Id(position);
        session.setAttribute("position",position1);

        return "manager/changePosition";
    }

    /*转到面试邀请界面*/
    @RequestMapping(value = "/forInterview")
    public ModelAndView forInterview(Offer offer) throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        Offer offer1 = offerService.getOfferById(offer);

        modelAndView.addObject("offer",offer1);
        modelAndView.setViewName("manager/doInterview");
        return modelAndView;
    }

    /*跳转到显示职位信息界面*/
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
