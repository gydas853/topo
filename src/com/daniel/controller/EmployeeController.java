package com.daniel.controller;

import com.daniel.model.Employee;
import com.daniel.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-01-26.
 */
@Controller
/* 员工部分的controller*/
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/employeeLogin")
    public String employeeLogin(Employee employee) throws Exception{

        Employee employee1 = employeeService.getOne(employee);

        if(null != employee1){
            return "employee/employeeMain";
        }
        return null;
    }
}
