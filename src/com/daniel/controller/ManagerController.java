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
    private OfferService offerService;

    @Resource
    private InterviewService interviewService;

    @Resource
    private EmployeeService employeeService;

    /*����Ա��¼*/
    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    public String managerLogin(HttpSession session,Manager manager) throws Exception{

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){

            /*��ʾ��˾��Ϣ*/
            Company company = companyService.getCompany();
            session.setAttribute("company",company);

            /*ȫ��������Ϣ*/
            List<Department> departments = departmentService.listAll();
            session.setAttribute("departments",departments);

            /*ȫ����Ƹ��Ϣ*/
            List<Recruit> recruits = recruitService.listAll();
            session.setAttribute("recruits",recruits);

            /*ȫ���ļ�����Ϣ*/
            List<Offer> offers = offerService.listAllState_0();
            session.setAttribute("offers",offers);

            /*ȫ����Ա����Ϣ*/
            List<Employee> employees = employeeService.listAll();
            session.setAttribute("employees",employees);

            /*����Ա��Ϣ*/
            session.setAttribute("manager",manager1);
            return "manager/managerMain";
        }else {
            return "manager/managerLogin";
        }
    }

    /*����Ա������Ƹ��Ϣ*/
    @RequestMapping(value = "/addRecruit",method = RequestMethod.POST)
    public String addRecruit(HttpSession session,Recruit recruit) throws Exception{

        recruitService.addRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();

        session.setAttribute("recruits",recruits);
        return "manager/managerMain";
    }

    /*����ְλ��������*/
    @RequestMapping(value = "/getPositionByD_name")
    public @ResponseBody List<Position> getPositionByD_name(Position position) throws Exception{

        List<Position> positions = positionService.listAllByP_d_id(position);

        return positions;
    }
    /*����Ա�޸���Ƹ��Ϣ*/
    @RequestMapping(value = "/changeRecruit",method = RequestMethod.POST)
    public String changeRecruit(HttpSession session,Recruit recruit) throws Exception{

        /*�������ݿ�*/
        recruitService.updateRecruit(recruit);
        /*����session*/
        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);
        return "manager/managerMain";
    }

    /*����Աɾ����Ƹ��Ϣ*/
    @RequestMapping(value = "/deleteRecruit",method = RequestMethod.POST)
    public String deleteRecruit(HttpSession session,Recruit recruit) throws Exception{
        /*ɾ��һ����Ƹ��Ϣ*/
        recruitService.deleteRecruit(recruit);

        List<Recruit> recruits = recruitService.listAll();
        session.setAttribute("recruits",recruits);

        return "manager/managerMain";
    }

    /*����Ա����һ����˾��Ϣ*/
    @RequestMapping(value = "/changeCompany",method = RequestMethod.POST)
    public String changeCompany(HttpSession session,Company company) throws Exception{

        companyService.updateCompany(company);

        Company company1 = companyService.getCompany();
        session.setAttribute("company",company1);

        return "manager/managerMain";
    }

    /*����Ա����һ��������Ϣ*/
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

    /*����Ա����һ��������Ϣ*/
    @RequestMapping(value = "/changeDepartment",method = RequestMethod.POST)
    public String changeDepartment(HttpSession session,Department department) throws Exception{

        /*�ȸ��²��ű����Ϣ*/
        Department department1 = departmentService.getDepartmentByD_id(department);

        department1.setD_name(department.getD_name());

        departmentService.updateDepartment(department1);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "manager/managerMain";
    }

    /*����Աɾ��һ��������Ϣ*/
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public String deleteDepartment(HttpSession session,Department department) throws Exception{

        departmentService.deleteDepartment(department);

        List<Department> departments = departmentService.listAll();
        session.setAttribute("departments",departments);

        return "manager/managerMain";
    }

    /*����Ա����һ��ְλ��Ϣ*/
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

    /*����Ա����һ��ְλ��Ϣ*/
    @RequestMapping(value = "/changePosition",method = RequestMethod.POST)
    public String changePosition(HttpSession session,Position position) throws Exception{

        Position position1 = positionService.getPositionByP_Id(position);

        position1.setP_name(position.getP_name());

        positionService.updatePosition(position);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        return "manager/position";
    }

    /*����Աɾ��һ��ְλ��Ϣ*/
    @RequestMapping(value = "/deletePosition",method = RequestMethod.POST)
    public String deletePosition(HttpSession session,Position position) throws Exception{

        positionService.deletePosition(position);

        List<Position> positions = positionService.listAllByP_d_id(position);
        session.setAttribute("positions",positions);

        return "manager/position";
    }

    /*����Ա����һ����������*/
    @RequestMapping(value = "/sendInterview")
    public String sendInterview(HttpSession session,Interview interview,Offer offer) throws Exception{

        interviewService.addInterview(interview);

        Interview interview1 = interviewService.getInterviewByI_g_id(interview);

        session.setAttribute("interview",interview1);

        /*�ҵ���Ӧ��offer*/
        Offer offer1 = offerService.getOneByR_idAndG_id(offer);
        offer1.setO_state(1);
        /*����offer����*/
        offerService.updateOffer(offer1);

        return "manager/managerMain";
    }

}
