package com.daniel.service;

import com.daniel.model.Department;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface DepartmentService {
    boolean addDepartment(Department department);//增加一个部门
    boolean updateDepartment(Department department);//更新部门信息
    boolean deleteDepartment(Department department);//删除一个部门
    List<Department> listAll();//列出所有部门
    Department getDepartment(Department department);//找到一个部门
}
