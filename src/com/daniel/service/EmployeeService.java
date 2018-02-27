package com.daniel.service;

import com.daniel.model.Employee;

import java.util.List;

/**
 * Created by nero0 on 2018-02-23.
 */
public interface EmployeeService {
    boolean addEmployee(Employee employee);//增加一个员工
    boolean updateEmployee(Employee employee);//更新员工信息
    //boolean deleteEmployee(Employee employee);//删除一个员工 有可能用不到
    Employee getOne(Employee employee);
    List<Employee> listByDepartment(Employee employee);//通过部门查找所有员工
    List<Employee> listByPosition(Employee employee);//通过职位查找所有员工
    List<Employee> getOneByE_id(Employee employee);//通过id查找员工
    List<Employee> listAll();//列出所有
}
