package com.daniel.service;

import com.daniel.model.Department;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(Department department);
    List<Department> listAll();
    Department getDepartment(Department department);
}
