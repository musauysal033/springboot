package com.example.service;

import com.example.common.exception.BusinessException;
import com.example.entity.Company;

import java.util.List;

public interface CompanyService {
    Company retrieveCompanyByCompanyCode(String companyCode);

    Company create(Company company) throws BusinessException;

    void deleteCompany(Integer companyId);

    List<Company> getAll();

    Company get(Integer companyId);
}
