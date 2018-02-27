package com.daniel.service;

import com.daniel.model.Employee;

import java.util.List;

/**
 * Created by nero0 on 2018-02-23.
 */
public interface EmployeeService {
    boolean addEmployee(Employee employee);//����һ��Ա��
    boolean updateEmployee(Employee employee);//����Ա����Ϣ
    //boolean deleteEmployee(Employee employee);//ɾ��һ��Ա�� �п����ò���
    Employee getOne(Employee employee);
    List<Employee> listByDepartment(Employee employee);//ͨ�����Ų�������Ա��
    List<Employee> listByPosition(Employee employee);//ͨ��ְλ��������Ա��
    List<Employee> getOneByE_id(Employee employee);//ͨ��id����Ա��
    List<Employee> listAll();//�г�����
}
