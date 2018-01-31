package com.daniel.dao;

import com.daniel.model.Company;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface CompanyMapper {
    boolean addCompany(Company company);//����һ����˾
    boolean updateCompany(Company company);//���¹�˾��Ϣ
    boolean deleteCompany(Company company);//ɾ��һ����˾
    List<Company> listAll();//�г����й�˾
    Company getCompany(Company company);//�ҵ�һ����˾
}
