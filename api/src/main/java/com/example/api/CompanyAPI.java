package com.example.api;

import com.example.common.exception.ApiSuccess;
import com.example.entity.Company;
import com.example.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/company")
public class CompanyAPI {

    @Autowired
    CompanyService companyService;



    /*
     * GET MAPPING
     * */
    @GetMapping("/get-all")
    public ResponseEntity<?> retrieveAllCompany() {
        return new ResponseEntity<>(new ApiSuccess("Tüm Şirketler Listelendi",companyService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/get/{companyId}")
    public ResponseEntity<?> retrieveCompanyById(@PathVariable("companyId")Integer companyId) {
        return new ResponseEntity<>(new ApiSuccess("Id'e göre bir şirket silindi",companyService.get(companyId)),HttpStatus.OK);
    }


    /*
     * POST MAPPING
     * */

    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(new ApiSuccess("Şirket Kaydedildi",companyService.create(company)),HttpStatus.OK);

    }
    /*
     * DELETE MAPPING
     * */

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<?> delete(@PathVariable("companyId")Integer companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(new ApiSuccess("Şirket Silindi",null),HttpStatus.OK);

    }
}
