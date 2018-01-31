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
/*MyController�������� ��һЩ�Ƚϼ򵥵���ҳ��ת�ŵ�һ��*/
public class MyController {

    @Resource
    private RecruitService recruitService;

    @Resource
    private CompanyService companyService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    /*��ת��ϵͳ����*/
    @RequestMapping(value = "/forSystem")
    public String forSystem() throws Exception{
        /*����system.jsp*/
        return "system";
    }

    /*ʹ�οͷ�����ҳ*/
    @RequestMapping(value = "/forMain")
    public ModelAndView forMain() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Recruit> recruits = recruitService.listAll();
        modelAndView.addObject("recruits",recruits);
        modelAndView.setViewName("main");

        return modelAndView;
    }

    /*����Ա��¼ϵͳ*/
    @RequestMapping(value = "/forManagerLogin")
    public String forLogin() throws Exception{
        /*�������Ա��¼����*/
        return "managerLogin";
    }

    /*Ա����¼*/
    @RequestMapping(value = "/forEmployeeLogin")
    public String forEmployeeLogin() throws Exception{
        return "employeeLogin";
    }

    /*ʹ����Աǰ���޸���Ƹ��Ϣҳ��*/
    @RequestMapping(value = "/forChangeRecruit")
    public ModelAndView forChangeRecruit(Recruit recruit) throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        Recruit recruit1 = recruitService.getRecruitById(recruit);

         /*ȫ����˾��Ϣ*/
        List<Company> companies = companyService.listAll();
        modelAndView.addObject("companies",companies);

        /*ȫ��������Ϣ*/
        List<Department> departments = departmentService.listAll();
        modelAndView.addObject("departments",departments);

        /*ȫ��ְλ��Ϣ*/
        List<Position> positions = positionService.listAll();
        modelAndView.addObject("positions",positions);

        modelAndView.addObject("recruit",recruit1);
        modelAndView.setViewName("changeRecruit");
        return modelAndView;
    }
}
