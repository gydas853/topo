package com.daniel.service.impl;

import com.daniel.dao.CompanyMapper;
import com.daniel.model.Company;
import com.daniel.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nero0 on 2018-01-28.
 */
@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService{

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public boolean addCompany(Company company) {
        return companyMapper.addCompany(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    @Override
    public boolean deleteCompany(Company company) {
        return companyMapper.deleteCompany(company);
    }

    @Override
    public List<Company> listAll() {
        return companyMapper.listAll();
    }

    @Override
    public Company getCompanyByC_id(Company company) {
        return companyMapper.getCompanyByC_id(company);
    }
}
