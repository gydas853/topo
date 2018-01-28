package com.daniel.dao;

import com.daniel.model.Company;

import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
public interface CompanyMapper {
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(Company company);
    List<Company> listAll();
    Company getCompany(Company company);
}
