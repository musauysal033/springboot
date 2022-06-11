package com.example.service.validator;

import com.example.common.exception.ErrorMessageUtil;
import com.example.common.exception.MetaMessageUtil;
import com.example.entity.Company;
import com.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CompanyValidator {

    @Autowired
    CompanyService companyService;

    private MetaMessageUtil metaMessageUtil = new MetaMessageUtil();

    public void validateSaveForCompanyDatabase(Company company){
        metaMessageUtil = new MetaMessageUtil();

        if (company.getCompanyId() == null ){
            Company tmpCompany = companyService.retrieveCompanyByCompanyCode(company.getCompanyCode());
            if(tmpCompany != null ){
                metaMessageUtil.addMetaMessageWarning("Kaydedilmeye Çalışılan Şirketin" +(company.getCompanyCode())+" Bezersiz Olmalıdır.");
            }
        }else {
            Company tmpCompany = companyService.retrieveCompanyByCompanyCode(company.getCompanyCode());
            if(tmpCompany != null){
                if(Objects.equals(company.getCompanyCode(),tmpCompany.getCompanyCode())){
                    metaMessageUtil.addMetaMessageWarning("Kaydedilmeye Çalışılan Şirketin" +(company.getCompanyCode())+" Bezersiz Olmalıdır.");
                }
            }
        }
        ErrorMessageUtil.checkBusinessException(metaMessageUtil);
    }
}
