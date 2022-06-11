package com.example.api;


import com.example.common.exception.ApiSuccess;
import com.example.entity.Company;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeAPI {

    @Autowired
    EmployeeService employeeService;

    /*
     * GET MAPPING
     * */
    @GetMapping("/get-all")
    public ResponseEntity<?> retrieveAllEmployee() {
        return new ResponseEntity<>(new ApiSuccess("Tüm Çalışanlar Listelendi",employeeService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<?> retrieveEmployeeById(@PathVariable("employeeId")Integer employeeId) {
        return new ResponseEntity<>(new ApiSuccess("Id'ye göre bir çalışan getirildi ",employeeService.get(employeeId)),HttpStatus.OK);
    }


    /*
     * POST MAPPING
     * */

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(new ApiSuccess("Çalışan Kaydedildi",employeeService.create(employee)),HttpStatus.OK);

    }
    /*
     * DELETE MAPPING
     * */

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> delete(@PathVariable("employeeId")Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new ApiSuccess("Çalışan Silindi",null),HttpStatus.OK);

    }
}
