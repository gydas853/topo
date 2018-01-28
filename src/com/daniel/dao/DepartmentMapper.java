package com.daniel.dao;

import com.daniel.model.Department;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface DepartmentMapper {
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(Department department);
    List<Department> listAll();
    Department getDepartment(Department department);
}
