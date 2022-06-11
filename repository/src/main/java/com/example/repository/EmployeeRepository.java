package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeCode(String employeeCode);

    Employee findByEmployeeId(Integer employeeId);

    @Modifying
    @Query(value = "delete from Employee e where e.employeeId = :employeeId")
    void deleteEmployee(@Param("employeeId") Integer employeeId);
}
