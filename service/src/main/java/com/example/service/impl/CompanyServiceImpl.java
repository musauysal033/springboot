package com.example.service.impl;


import com.example.common.exception.BusinessException;
import com.example.entity.Company;
import com.example.repository.CompanyRepository;
import com.example.service.CompanyService;
import com.example.service.validator.CompanyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyValidator companyValidator;


    @Override
    public Company retrieveCompanyByCompanyCode(String companyCode) {
        return companyRepository.findByCompanyCode(companyCode);
    }

    @Transactional
    @Override
    public Company create(Company company) throws BusinessException {
        companyValidator.validateSaveForCompanyDatabase(company);
        return companyRepository.save(company);
    }
    @Override
    @Transactional
    public void deleteCompany(Integer companyId) {
        companyRepository.deleteCompany(companyId);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }


    @Override
    public Company get(Integer companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
}
