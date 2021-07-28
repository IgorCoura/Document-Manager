package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.domain.models.document.CreateDocumentModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentModel> register(@RequestBody CreateDocumentModel model){
        var resp = documentService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
