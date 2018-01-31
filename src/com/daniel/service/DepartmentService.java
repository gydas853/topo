package com.daniel.service;

import com.daniel.model.Department;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public interface DepartmentService {
    boolean addDepartment(Department department);//����һ������
    boolean updateDepartment(Department department);//���²�����Ϣ
    boolean deleteDepartment(Department department);//ɾ��һ������
    List<Department> listAll();//�г����в���
    Department getDepartment(Department department);//�ҵ�һ������
}
