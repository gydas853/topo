package com.daniel.dao;

import com.daniel.model.Company;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface CompanyMapper {
    boolean updateCompany(Company company);//更新公司信息
    Company getCompany();//显示公司
}
