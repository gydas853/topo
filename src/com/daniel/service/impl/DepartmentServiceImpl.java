package com.daniel.service.impl;

import com.daniel.dao.DepartmentMapper;
import com.daniel.model.Department;
import com.daniel.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public boolean addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        return departmentMapper.deleteDepartment(department);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.listAll();
    }

    @Override
    public Department getDepartmentByD_id(Department department) {
        return departmentMapper.getDepartmentByD_id(department);
    }

    @Override
    public Department getDepartmentByD_name(Department department) {
        return departmentMapper.getDepartmentByD_name(department);
    }

}
