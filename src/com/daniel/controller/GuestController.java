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

    /*�ο͵�¼*//*��δ��������*/
    @RequestMapping(value = "/guestLogin",method = RequestMethod.POST)
    public String guestLogin(HttpSession session,Guest guest) throws Exception{
        /*�ҵ��ο���Ϣ*/
        Guest guest1 = guestService.getGuest(guest);
        if(null != guest1){
            Vitae vitae = new Vitae();
            vitae.setV_g_id(guest1.getG_id());

            /*�鵽���ο͵ļ���*/
            Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
            /*�û��ļ����浽session��*/
            session.setAttribute("vitae",vitae1);

            Interview interview = new Interview();
            interview.setI_g_id(guest1.getG_id());

             /*��ѯ���ο͵���������*/
            Interview interview1 = interviewService.getInterviewByI_g_id(interview);
            session.setAttribute("interview",interview1);

            /*�û���Ϣ�浽session*/
            session.setAttribute("guest",guest1);

            return "guest/guestMain";
        }
        return "main";

    }

    /*�ο�ע���Ϊ��Ա*//*ͬ���������ظ�������*/
    @RequestMapping(value = "/register")
    public String register(Guest guest) throws Exception{


        guestService.addGuest(guest);

        return "main";
    }

    /*�ο���Ӽ���*//*��δ��������*/
    @RequestMapping(value = "/addVitae")
    public String addVitae(HttpSession session,Vitae vitae) throws Exception{

        vitaeService.addVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guest/guestMain";
    }

    /*�ο��޸ļ���*//*��δ��������*/
    @RequestMapping(value = "/changeVitae")
    public String changeVitae(HttpSession session,Vitae vitae) throws Exception{
        vitaeService.updateVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByV_id(vitae);
        session.setAttribute("vitae",vitae1);
        return "guest/guestMain";
    }

    /*�ο�ɾ������*//*��δ��������*/
    @RequestMapping(value = "/deleteVitae",method = RequestMethod.POST)
    public String deleteVitae(HttpSession session,Vitae vitae)throws Exception{
        vitaeService.deleteVitae(vitae);

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);
        session.setAttribute("vitae",vitae1);

        return "guest/guestMain";
    }

    /*�ο�Ͷ����*/
    @RequestMapping(value = "/offerToJob",method = RequestMethod.POST)
    public ModelAndView offerJob(Offer offer) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        offerService.addOffer(offer);
        modelAndView.setViewName("guest/guestMain");

        return modelAndView;
    }

    /*��ΪԱ��*/
    @RequestMapping(value = "/employ")
    public String employ(HttpSession session,Interview interview) throws Exception{

        /*�ҵ�����������Ϣ*/
        Interview interview1 = interviewService.getInterviewByI_g_id(interview);
        interview1.setI_result(1);
        /*��������*/
        interviewService.updateInterview(interview1);

        Interview interview2 = interviewService.getInterviewByI_g_id(interview);
        session.setAttribute("interview",interview2);

        /*��һ��Ա���˺�*/

        /*�����Ա�鵽��Ҫ����Ϣ*/
        Interview interview3 = interviewService.getIngerviewByR_idAndG_id(interview);

        /*��̸�õĹ��ʴ浽Ա����Ϣ��*/
        Recruit recruit = new Recruit();
        recruit.setR_id(interview3.getI_r_id());
        Recruit recruit1 = recruitService.getRecruitByR_id(recruit);

        /*���ż�һ����*/
        Department department = new Department();
        department.setD_name(interview3.getI_d_name());

        Department department1 = departmentService.getDepartmentByD_name(department);

        department1.setD_number(department1.getD_number()+1);
        departmentService.updateDepartment(department1);

        /*Ա����һ����*/
        Position position = new Position();
        position.setP_name(interview3.getI_p_name());
        position.setP_d_id(department1.getD_id());

        Position position1 = positionService.getPositionByP_name(position);

        position1.setP_number(position1.getP_number()+1);

        positionService.updatePosition(position1);

        /*�ҵ��ο͵ļ���*/
        Vitae vitae = new Vitae();
        vitae.setV_g_id(interview3.getI_g_id());

        Vitae vitae1 = vitaeService.getVitaeByG_id(vitae);

        /*���ο͵��˺����븳��Ա��*/
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
        employee.setE_training("����");
        employee.setE_state("��ְ");

        employeeService.addEmployee(employee);

        return "guest/guestMain";
    }
}
