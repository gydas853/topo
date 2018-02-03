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
    private CompanyService companyService;

    @Resource
    private DepartmentService departmentService;

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
        return "managerLogin";
    }

    /*员工登录*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employeeLogin";
    }

    /*使管理员前往修改招聘信息页面*/
    @RequestMapping(value = "/forChangeRecruit",method = RequestMethod.POST)
    public String forChangeRecruit(HttpSession session,Recruit recruit) throws Exception{

        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);
        session.setAttribute("recruit",recruit1);

        return "changeRecruit";
    }

    /*返回管理员主界面*/
    @RequestMapping(value = "/forManagerMain")
    public String forManagerMain() throws Exception{
        return "managerMain";
    }

    /*使管理员前往修改公司信息页面*/
    @RequestMapping(value = "/forChangeCompany")
    public String forChangeCompany(HttpSession session,Company company) throws Exception{

        Company company1 = companyService.getCompanyByC_id(company);
        session.setAttribute("company",company1);

        return "changeCompany";
    }

    /*使管理员前往修改公司部门信息界面*/
    @RequestMapping(value = "/forChangeDepartment")
    public String forChangeDepartment(HttpSession session,Department department) throws Exception{

        Department department1 = departmentService.getDepartmentByD_id(department);
        session.setAttribute("department",department1);

        return "changeDepartment";
    }
}
