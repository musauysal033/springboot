package com.example.repository;

import com.example.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
    Company findByCompanyCode(String companyCode);
    Company findByCompanyId(Integer companyId);

    @Modifying
    @Query(value = "delete from Company c where c.companyId = :companyId")
    void deleteCompany(@Param("companyId") Integer companyId);
}
