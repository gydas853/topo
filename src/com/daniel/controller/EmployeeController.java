package com.daniel.controller;

import com.daniel.model.Manager;
import com.daniel.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/*�ݶ�Ϊ Ա�����ֵĵ�controller*/
public class EmployeeController {
    /*����Ա��Ա�������ڹ�˾ְԱ*/

    /*����Ա��Դ*/
    @Resource
    private ManagerService managerService;

    /*Ա����Դ*/

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Manager manager = new Manager();
        manager.setM_name(name);
        manager.setM_pass(pass);

        Manager manager1 = managerService.getManager(manager);
        if(null != manager1){
            modelAndView.addObject("manager",manager1);
            modelAndView.setViewName("employeeMain");
            return modelAndView;
        }else {
            modelAndView.setViewName("employeeLogin");
            return modelAndView;
        }
    }
}
