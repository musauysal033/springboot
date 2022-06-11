package com.example.service.impl;

import com.example.common.exception.BusinessException;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import com.example.service.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeValidator employeeValidator;


    @Override
    public Employee retrieveEmployeeByEmployeeCode(String employeeCode) {
        return employeeRepository.findByEmployeeCode(employeeCode);
    }

    @Override
    @Transactional
    public Employee create(Employee employee) throws BusinessException {
        employeeValidator.validateSaveForEmployeeDatabase(employee);
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(Integer employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }
}
