package com.daniel.service.impl;

import com.daniel.dao.EmployeeMapper;
import com.daniel.model.Employee;
import com.daniel.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-02-23.
 */
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public Employee getOne(Employee employee) {
        return employeeMapper.getOne(employee);
    }

    @Override
    public List<Employee> listByDepartment(Employee employee) {
        return employeeMapper.listByDepartment(employee);
    }

    @Override
    public List<Employee> listByPosition(Employee employee) {
        return employeeMapper.listByPosition(employee);
    }

    @Override
    public List<Employee> getOneByE_id(Employee employee) {
        return employeeMapper.getOneByE_id(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }
}
