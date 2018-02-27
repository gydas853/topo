package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private OfferService offerService;

    @Resource
    private InterviewService interviewService;

    @Resource
    private EmployeeService employeeService;

    /*管理员登录*/
    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    public String managerLogin(HttpSession session,Manager manager) throws Exception{

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){

            /*显示公司信息*/
            Company company = companyService.getCompany();
            session.setAttribute("company",company);

            /*全部部门信息*/
            List<Department> departments = departmentService.listAll();
            session.setAttribute("departments",departments);

            /*全部招聘信息*/
            List<Recruit> recruits = recruitService.listAll();
            session.setAttribute("recruits",recruits);

            /*全部的简历信息*/
            List<Offer> offers = offerService.listAllState_0();
            session.setAttribute("offers",offers);

            /*全部的员工信息*/
            List<Employee> employees = employeeService.listAll();
            session.setAttribute("employees",employees);

            /*管理员信息*/
            session.setAttribute("manager",manager1);
            return "manager/managerMain";
        }else {
            return "manager/managerLogin";
        }
    }

    /*管理员发布招聘信息*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpSession session,Recruit recruit) throws Exception{

        recruitService.addRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();

        session.setAttribute("recruits",recruits);
        return "manager/managerMain";
    }

    /*部门职位二级联动*/
    @RequestMapping(value = "/getPositionByD_name")
    public @ResponseBody List<Position> getPositionByD_name(Position position) throws Exception{

        List<Position> positions = positionService.listAllByP_d_id(position);

        return positions;
    }
    /*管理员修改招聘信息*/
    @RequestMapping(value = "/changeRecruit",method = RequestMethod.POST)
    public String changeRecruit(HttpSession session,Recruit recruit) throws Exception{

        /*更新数据库*/
        recruitService.updateRecruit(recruit);
        /*更新session*/
        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);
        return "manager/managerMain";
    }

    /*管理员删除招聘信息*/
    @RequestMapping(value = "/deleteRecruit",method = RequestMethod.POST)
    public String deleteRecruit(HttpSession session,Recruit recruit) throws Exception{
        /*删除一个招聘信息*/
        recruitService.deleteRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);

        return "manager/managerMain";
    }

    /*管理员更新一个公司信息*/
    @RequestMapping(value = "/changeCompany",method = RequestMethod.POST)
    public String changeCompany(HttpSession session,Company company) throws Exception{

        companyService.updateCompany(company);

        Company company1 = companyService.getCompany();
        session.setAttribute("company",company1);

        return "manager/managerMain";
    }

    /*管理员增加一个部门信息*/
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public String addDepartment(HttpSession session,Department department) throws Exception{

        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d_createTime = sdf.format(date);
        department.setD_createTime(d_createTime);

        departmentService.addDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "manager/managerMain";
    }

    /*管理员更新一个部门信息*/
    @RequestMapping(value = "/changeDepartment",method = RequestMethod.POST)
    public String changeDepartment(HttpSession session,Department department) throws Exception{

        /*先更新部门表的信息*/
        Department department1 = departmentService.getDepartmentByD_id(department);

        department1.setD_name(department.getD_name());

        departmentService.updateDepartment(department1);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "manager/managerMain";
    }

    /*管理员删除一个部门信息*/
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public String deleteDepartment(HttpSession session,Department department) throws Exception{

        departmentService.deleteDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "manager/managerMain";
    }

    /*管理员增加一个职位信息*/
    @RequestMapping(value = "/addPosition")
    public String addPosition(HttpSession session,Position position) throws Exception{

        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String p_createTime = sdf.format(date);
        position.setP_createTime(p_createTime);

        positionService.addPosition(position);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        return "manager/position";
    }

    /*管理员更新一个职位信息*/
    @RequestMapping(value = "/changePosition",method = RequestMethod.POST)
    public String changePosition(HttpSession session,Position position) throws Exception{

        Position position1 = positionService.getPositionByP_Id(position);

        position1.setP_name(position.getP_name());

        positionService.updatePosition(position);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        return "manager/position";
    }

    /*管理员删除一个职位信息*/
    @RequestMapping(value = "/deletePosition",method = RequestMethod.POST)
    public String deletePosition(HttpSession session,Position position) throws Exception{

        positionService.deletePosition(position);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        return "manager/position";
    }

    /*管理员发送一个面试邀请*/
    @RequestMapping(value = "/sendInterview")
    public String sendInterview(HttpSession session,Interview interview,Offer offer) throws Exception{

        interviewService.addInterview(interview);

        Interview interview1 = interviewService.getInterviewByI_g_id(interview);

        session.setAttribute("interview",interview1);

        /*找到相应的offer*/
        Offer offer1 = offerService.getOneByR_idAndG_id(offer);
        offer1.setO_state(1);
        /*更新offer数据*/
        offerService.updateOffer(offer1);

        return "manager/managerMain";
    }

}
