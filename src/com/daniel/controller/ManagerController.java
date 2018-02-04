package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
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

    @Resource
    private OfferService offerService;

    /*管理员登录*/
    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    public String managerLogin(HttpSession session,Manager manager) throws Exception{

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){

            /*全部公司信息*/
            List<Company> companies = companyService.listAll();
            session.setAttribute("companies",companies);

            /*全部部门信息*/
            List<Department> departments = departmentService.listAll();
            session.setAttribute("departments",departments);

            /*全部职位信息*/
            List<Position> positions = positionService.listAll();
            session.setAttribute("positions",positions);

            /*全部招聘信息*/
            List<Recruit> recruits = recruitService.listAll();
            session.setAttribute("recruits",recruits);

            /*管理员信息*/
            session.setAttribute("manager",manager1);
            return "managerMain";
        }else {
            return "managerLogin";
        }
    }

    /*管理员发布招聘信息*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpSession session,Recruit recruit) throws Exception{

        recruitService.addRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();

        session.setAttribute("recruits",recruits);
        return "managerMain";
    }

    /*管理员修改招聘信息*/
    @RequestMapping(value = "/changeRecruit",method = RequestMethod.POST)
    public String changeRecruit(HttpSession session,Recruit recruit) throws Exception{

        /*更新数据库*/
        recruitService.updateRecruit(recruit);
        /*更新session*/
        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);
        return "managerMain";
    }

    /*管理员删除招聘信息*/
    @RequestMapping(value = "/deleteRecruit",method = RequestMethod.POST)
    public String deleteRecruit(HttpSession session,Recruit recruit) throws Exception{
        /*删除一个招聘信息*/
        recruitService.deleteRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);

        return "managerMain";
    }

    /*管理员增加一个公司*/
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    public String addCompany(HttpSession session,Company company) throws Exception{

        companyService.addCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*管理员更新一个公司信息*/
    @RequestMapping(value = "/changeCompany",method = RequestMethod.POST)
    public String changeCompany(HttpSession session,Company company) throws Exception{

        companyService.updateCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*管理员删除一个公司信息*/
    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST)
    public String deleteCompany(HttpSession session,Company company) throws Exception{

        companyService.deleteCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*管理员增加一个部门信息*/
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public String addDepartment(HttpSession session,Department department) throws Exception{

        departmentService.addDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }

    /*管理员更新一个部门信息*/
    @RequestMapping(value = "/changeDepartment",method = RequestMethod.POST)
    public String changeDepartment(HttpSession session,Department department) throws Exception{

        departmentService.updateDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }

    /*管理员删除一个部门信息*/
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public String deleteDepartment(HttpSession session,Department department) throws Exception{

        departmentService.deleteDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }
}
