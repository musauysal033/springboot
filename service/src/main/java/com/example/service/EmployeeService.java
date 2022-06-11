package com.example.service;

import com.example.common.exception.BusinessException;
import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee retrieveEmployeeByEmployeeCode(String employeeCode);

    Employee create(Employee employee) throws BusinessException;

    void deleteEmployee(Integer employeeId);

    List<Employee> getAll();

    Employee get(Integer employeeId);
}
