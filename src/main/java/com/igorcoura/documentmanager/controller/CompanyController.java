package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.domain.models.CompanyModel;
import com.igorcoura.documentmanager.domain.models.CreateCompanyModel;
import com.igorcoura.documentmanager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyModel> register(@RequestBody CreateCompanyModel model){
        var resp = companyService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping
    public ResponseEntity<CompanyModel> update(@RequestBody CompanyModel model){
        var resp = companyService.update(model);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<CompanyModel>> recoverAll(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.recoverAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> recover(@RequestParam("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.recover(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@RequestParam("id") long id) {
        companyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
