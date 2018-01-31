package com.daniel.dao;

import com.daniel.model.Company;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface CompanyMapper {
    boolean addCompany(Company company);//增加一个公司
    boolean updateCompany(Company company);//更新公司信息
    boolean deleteCompany(Company company);//删除一个公司
    List<Company> listAll();//列出所有公司
    Company getCompanyByC_id(Company company);//找到一个公司
}
