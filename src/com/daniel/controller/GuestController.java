package com.daniel.controller;

import com.daniel.model.*;
import com.daniel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by nero0 on 2018-01-27.
 */
@Controller
public class GuestController {

    @Resource
    private GuestService guestService;

    @Resource
    private InterviewService interviewService;

    @Resource
    private VitaeService vitaeService;

    @Resource
    private OfferService offerService;

    @Resource
    private RecruitService recruitService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    /*游客登录*//*暂未发现问题*/
    @RequestMapping(value = "/guestLogin",method = RequestMethod.POST)
    public String guestLogin(HttpSession session,Guest guest) throws Exception{
        /*找到游客信息*/
        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            Vitae vitae = new Vitae();
            vitae.setV_g_id(guest1.getG_id());

            /*查到此游客的简历*/
            Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
            /*用户的简历存到session里*/
            session.setAttribute("vitae",vitae1);

            Interview interview = new Interview();
            interview.setI_g_id(guest1.getG_id());

             /*查询此游客的面试邀请*/
            Interview interview1 = interviewService.getInterviewByI_g_id(interview);
            session.setAttribute("interview",interview1);

            /*用户信息存到session*/
            session.setAttribute("guest",guest1);

            return "guest/guestMain";
        }
        return "main";

    }

    /*游客注册成为会员*//*同名的问题重复的问题*/
    @RequestMapping(value = "/register")
    public String register(Guest guest) throws Exception{


        guestService.addGuest(guest);

        return "main";
    }

    /*游客添加简历*//*暂未发现问题*/
    @RequestMapping(value = "/addVitae")
    public String addVitae(HttpSession session,Vitae vitae) throws Exception{

        vitaeService.addVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guest/guestMain";
    }

    /*游客修改简历*//*暂未发现问题*/
    @RequestMapping(value = "/changeVitae")
    public String changeVitae(HttpSession session,Vitae vitae) throws Exception{
        vitaeService.updateVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByV_id(vitae);
        session.setAttribute("vitae",vitae1);
        return "guest/guestMain";
    }

    /*游客删除简历*//*暂未发现问题*/
    @RequestMapping(value = "/deleteVitae",method = RequestMethod.POST)
    public String deleteVitae(HttpSession session,Vitae vitae)throws Exception{
        vitaeService.deleteVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guest/guestMain";
    }

    /*游客投简历*/
    @RequestMapping(value = "/offerToJob",method = RequestMethod.POST)
    public ModelAndView offerJob(Offer offer) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        offerService.addOffer(offer);
        modelAndView.setViewName("guest/guestMain");

        return modelAndView;
    }

    /*成为员工*/
    @RequestMapping(value = "/employ")
    public String employ(HttpSession session,Interview interview) throws Exception{

        /*找到面试邀请信息*/
        Interview interview1 = interviewService.getInterviewByI_g_id(interview);
        interview1.setI_result(1);
        /*更新数据*/
        interviewService.updateInterview(interview1);

        Interview interview2 = interviewService.getInterviewByI_g_id(interview);
        session.setAttribute("interview",interview2);

        /*建一个员工账号*/

        /*从面试表查到需要的信息*/
        Interview interview3 = interviewService.getIngerviewByR_idAndG_id(interview);

        /*把谈好的工资存到员工信息中*/
        Recruit recruit = new Recruit();
        recruit.setR_id(interview3.getI_r_id());
        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);

        /*部门加一个人*/
        Department department = new Department();
        department.setD_name(interview3.getI_d_name());

        Department department1 = departmentService.getDepartmentByD_name(department);

        department1.setD_number(department1.getD_number()+1);
        departmentService.updateDepartment(department1);

        /*员工加一个人*/
        Position position = new Position();
        position.setP_name(interview3.getI_p_name());
        position.setP_d_id(department1.getD_id());

        Position position1 = positionService.getPositionByP_name(position);

        position1.setP_number(position1.getP_number()+1);

        positionService.updatePosition(position1);

        /*找到游客的简历*/
        Vitae vitae = new Vitae();
        vitae.setV_g_id(interview3.getI_g_id());

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);

        /*把游客的账号密码赋给员工*/
        Guest guest = new Guest();
        guest.setG_id(interview3.getI_g_id());

        Guest guest1 = guestService.getGuestById(guest);

        Employee employee = new Employee();

        employee.setE_name(guest1.getG_name());
        employee.setE_pass(guest1.getG_pass());
        employee.setE_trueName(interview3.getI_v_name());
        employee.setE_age(vitae1.getV_age());
        employee.setE_phone(vitae1.getV_tel());
        employee.setE_email(vitae1.getV_email());
        employee.setE_salary(Double.parseDouble(recruit1.getR_money()));
        employee.setE_department(interview3.getI_d_name());
        employee.setE_position(interview3.getI_p_name());
        employee.setE_training("暂无");
        employee.setE_state("在职");

        employeeService.addEmployee(employee);

        return "guest/guestMain";
    }
}
