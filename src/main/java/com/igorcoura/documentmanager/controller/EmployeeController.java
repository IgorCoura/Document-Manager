package com.igorcoura.documentmanager.controller;


import com.igorcoura.documentmanager.domain.models.company.CompanyModel;
import com.igorcoura.documentmanager.domain.models.company.CreateCompanyModel;
import com.igorcoura.documentmanager.domain.models.company.UpdateCompanyModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.service.CompanyService;
import com.igorcoura.documentmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeModel> register(@RequestBody CreateEmployeeModel model){
        var resp = employeeService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping
    public ResponseEntity<EmployeeModel> update(@RequestBody UpdateEmployeeModel model){
        var resp = employeeService.update(model);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> recoverAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.recoverAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> recover(@RequestParam("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.recover(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@RequestParam("id") long id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
