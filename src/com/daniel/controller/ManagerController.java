package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

            List<Company> companies = companyService.listAll();
            modelAndView.addObject("companies",companies);

            List<Department> departments = departmentService.listAll();
            modelAndView.addObject("departments",departments);

            List<Position> positions = positionService.listAll();
            modelAndView.addObject("positions",positions);

            modelAndView.addObject("manager",manager1);
            modelAndView.setViewName("managerMain");
            return modelAndView;
        }else {
            modelAndView.setViewName("managerLogin");
            return modelAndView;
        }
    }

    /*管理员发布招聘信息*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpServletRequest request) throws Exception{
        String r_name = request.getParameter("r_name");
        int r_c_id = Integer.parseInt(request.getParameter("r_c_id"));
        int r_d_id = Integer.parseInt(request.getParameter("r_d_id"));
        int r_p_id = Integer.parseInt(request.getParameter("r_p_id"));

        Recruit recruit = new Recruit();
        recruit.setR_name(r_name);
        recruit.setR_c_id(r_c_id);
        recruit.setR_d_id(r_d_id);
        recruit.setR_p_id(r_p_id);

        recruitService.addRecruit(recruit);
        return "employeeMain";
    }
}
