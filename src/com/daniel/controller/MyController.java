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
    private CompanyService companyService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    /*跳转到系统界面*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*进入system.jsp*/
        return "system";
    }

    /*使游客访问网页*/
    @RequestMapping(value = "/forMain")
    public ModelAndView forMain() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Recruit> recruits = recruitService.listAll();
        modelAndView.addObject("recruits",recruits);
        modelAndView.setViewName("main");

        return modelAndView;
    }

    /*管理员登录系统*/
    @RequestMapping(value = "/forManagerLogin")
    public String forLogin() throws Exception{
        /*进入管理员登录界面*/
        return "managerLogin";
    }

    /*员工登录*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employeeLogin";
    }

    /*使管理员前往修改招聘信息页面*/
    @RequestMapping(value = "/forChangeRecruit")
    public ModelAndView forChangeRecruit(Recruit recruit) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        Recruit recruit1 = recruitService.getRecruitById(recruit);

         /*全部公司信息*/
        List<Company> companies = companyService.listAll();
        modelAndView.addObject("companies",companies);

        /*全部部门信息*/
        List<Department> departments = departmentService.listAll();
        modelAndView.addObject("departments",departments);

        /*全部职位信息*/
        List<Position> positions = positionService.listAll();
        modelAndView.addObject("positions",positions);

        modelAndView.addObject("recruit",recruit1);
        modelAndView.setViewName("changeRecruit");
        return modelAndView;
    }
}
