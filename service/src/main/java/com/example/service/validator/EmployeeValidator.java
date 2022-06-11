package com.example.service.validator;

import com.example.common.exception.ErrorMessageUtil;
import com.example.common.exception.MetaMessageUtil;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmployeeValidator {

    @Autowired
    EmployeeService employeeService;

    private MetaMessageUtil metaMessageUtil = new MetaMessageUtil();

    public void validateSaveForEmployeeDatabase(Employee employee){
        metaMessageUtil = new MetaMessageUtil();

        if(employee.getEmployeeId() == null){
            Employee tmpEmployee = employeeService.retrieveEmployeeByEmployeeCode(employee.getEmployeeCode());
            if (tmpEmployee != null){
                metaMessageUtil.addMetaMessageWarning("Kaydedilmeye Çalışılan "+employee.getEmployeeCode()+" Benzersiz olmalıdır");
            }
        }else {
            Employee tmpEmployee = employeeService.retrieveEmployeeByEmployeeCode(employee.getEmployeeCode());
            if(tmpEmployee!=null){
                if(Objects.equals(tmpEmployee.getEmployeeCode(), employee.getEmployeeCode())){
                    metaMessageUtil.addMetaMessageWarning("Kaydedilmeye Çalışılan "+employee.getEmployeeCode()+" Benzersiz olmalıdır");
                }
            }
        }
        ErrorMessageUtil.checkBusinessException(metaMessageUtil);
    }

}
