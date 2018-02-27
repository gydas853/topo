package com.daniel.service;

import com.daniel.model.Company;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface CompanyService {
    boolean updateCompany(Company company);//更新公司信息
    Company getCompany();//找到一个公司
}
