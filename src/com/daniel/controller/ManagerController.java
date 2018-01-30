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
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Controller
public class ManagerController {

    /*管理员资源*/
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
    /*管理员登录*/
    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    public ModelAndView managerLogin(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Manager manager = new Manager();
        manager.setM_name(name);
        manager.setM_pass(pass);

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){

            /*全部公司信息*/
            List<Company> companies = companyService.listAll();
            modelAndView.addObject("companies",companies);

            /*全部部门信息*/
            List<Department> departments = departmentService.listAll();
            modelAndView.addObject("departments",departments);

            /*全部职位信息*/
            List<Position> positions = positionService.listAll();
            modelAndView.addObject("positions",positions);

            /*全部招聘信息*/
            List<Recruit> recruits = recruitService.listAll();
            modelAndView.addObject("recruits",recruits);

            /*管理员信息*/
            HttpSession session = request.getSession();
            session.setAttribute("manager",manager1);
            modelAndView.addObject("manager",manager1);
            modelAndView.setViewName("managerMain");
            return modelAndView;
        }else {
            modelAndView.setViewName("managerLogin");
            return modelAndView;
        }
    }

    /*管理员发布招聘信息*//*需要优化*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpServletRequest request) throws Exception{
        String r_name = request.getParameter("r_name");
        int r_c_id = Integer.parseInt(request.getParameter("r_c_id"));
        int r_d_id = Integer.parseInt(request.getParameter("r_d_id"));
        int r_p_id = Integer.parseInt(request.getParameter("r_p_id"));
        String r_money = request.getParameter("r_money");

        Recruit recruit = new Recruit();
        recruit.setR_name(r_name);
        recruit.setR_c_id(r_c_id);
        recruit.setR_d_id(r_d_id);
        recruit.setR_p_id(r_p_id);
        recruit.setR_money(r_money);

        recruitService.addRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        HttpSession session = request.getSession();
        session.setAttribute("recruits",recruits);
        return "managerMain";
    }

    /*管理员修改招聘信息*/
    @RequestMapping(value = "/changeRecruit",method = RequestMethod.POST)
    public ModelAndView changeRecruit(Recruit recruit) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        recruitService.updateRecruit(recruit);
        /*全部公司信息*/
        List<Company> companies = companyService.listAll();
        modelAndView.addObject("companies",companies);

            /*全部部门信息*/
        List<Department> departments = departmentService.listAll();
        modelAndView.addObject("departments",departments);

            /*全部职位信息*/
        List<Position> positions = positionService.listAll();
        modelAndView.addObject("positions",positions);

            /*全部招聘信息*/
        List<Recruit> recruits = recruitService.listAll();
        modelAndView.addObject("recruits",recruits);

        modelAndView.setViewName("managerMain");
        return modelAndView;
    }
    /*管理员删除招聘信息*/
    @RequestMapping(value = "/deleteRecruit")
    public ModelAndView deleteRecruit(Recruit recruit) throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        recruitService.deleteRecruit(recruit);

         /*全部公司信息*/
        List<Company> companies = companyService.listAll();
        modelAndView.addObject("companies",companies);

            /*全部部门信息*/
        List<Department> departments = departmentService.listAll();
        modelAndView.addObject("departments",departments);

            /*全部职位信息*/
        List<Position> positions = positionService.listAll();
        modelAndView.addObject("positions",positions);

            /*全部招聘信息*/
        List<Recruit> recruits = recruitService.listAll();
        modelAndView.addObject("recruits",recruits);

        modelAndView.setViewName("managerMain");
        return modelAndView;
    }
}
