package com.daniel.dao;

import com.daniel.model.Department;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface DepartmentMapper {
    boolean addDepartment(Department department);//����һ������
    boolean updateDepartment(Department department);//���²�����Ϣ
    boolean deleteDepartment(Department department);//ɾ��һ������
    List<Department> listAll();//�г����в���
    Department getDepartmentByD_id(Department department);//�ҵ�һ������
}
