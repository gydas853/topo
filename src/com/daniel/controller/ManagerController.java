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

    /*����Ա������Ƹ��Ϣ*/
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
    @RequestMapping(value = "/deleteRecruit",method = RequestMethod.POST)
    public String deleteRecruit(HttpSession session,Recruit recruit) throws Exception{
        /*ɾ��һ����Ƹ��Ϣ*/
        recruitService.deleteRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);

        return "managerMain";
    }

    /*����Ա����һ����˾*/
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    public String addCompany(HttpSession session,Company company) throws Exception{

        companyService.addCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*����Ա����һ����˾��Ϣ*/
    @RequestMapping(value = "/changeCompany",method = RequestMethod.POST)
    public String changeCompany(HttpSession session,Company company) throws Exception{

        companyService.updateCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*����Աɾ��һ����˾��Ϣ*/
    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST)
    public String deleteCompany(HttpSession session,Company company) throws Exception{

        companyService.deleteCompany(company);

        List<Company> companies = companyService.listAll();
        session.setAttribute("companies",companies);

        return "managerMain";
    }

    /*����Ա����һ��������Ϣ*/
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public String addDepartment(HttpSession session,Department department) throws Exception{

        departmentService.addDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }

    /*����Ա����һ��������Ϣ*/
    @RequestMapping(value = "/changeDepartment",method = RequestMethod.POST)
    public String changeDepartment(HttpSession session,Department department) throws Exception{

        departmentService.updateDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }

    /*����Աɾ��һ��������Ϣ*/
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public String deleteDepartment(HttpSession session,Department department) throws Exception{

        departmentService.deleteDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "managerMain";
    }
}
