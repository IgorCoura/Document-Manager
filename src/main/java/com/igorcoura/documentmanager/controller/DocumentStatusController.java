package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.CreateDocumentStatusModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.service.DocumentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-status")
public class DocumentStatusController {

    @Autowired
    private DocumentStatusService documentStatusService;

    @PostMapping
    public ResponseEntity<DocumentStatusModel> register(@RequestBody CreateDocumentStatusModel model){
        var resp = documentStatusService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<DocumentStatusModel>> recoverAll(){
        return ResponseEntity.status(HttpStatus.OK).body(documentStatusService.recoverAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<DocumentStatusModel>> recoverAll(@RequestParam(value = "status", required = false) String status, @RequestParam("entity") EntitiesEnum entity){
        return ResponseEntity.status(HttpStatus.OK).body(documentStatusService.recoverAll(status, entity));
    }

    @DeleteMapping("/{status}")
    public ResponseEntity<Void> remove(@RequestParam("status") String status) {
        documentStatusService.delete(status);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
