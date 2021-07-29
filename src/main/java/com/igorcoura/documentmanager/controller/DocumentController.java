package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.domain.models.document.CreateDocumentModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import com.igorcoura.documentmanager.domain.models.document.UpdateDocumentModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentModel> register(@RequestBody CreateDocumentModel model) throws Exception {
        var resp = documentService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping
    public ResponseEntity<DocumentModel> update(@RequestBody UpdateDocumentModel model) throws Exception {
        var resp = documentService.update(model);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<DocumentModel>> recoverAll(){
        return ResponseEntity.status(HttpStatus.OK).body(documentService.recoverAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentModel> recover(@RequestParam("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(documentService.recover(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@RequestParam("id") long id) {
        documentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
