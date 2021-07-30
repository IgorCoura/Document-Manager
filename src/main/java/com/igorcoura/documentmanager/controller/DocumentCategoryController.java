package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.DocumentCategoryModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.service.DocumentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/document-category")
public class DocumentCategoryController {

    @Autowired
    private DocumentCategoryService documentCategoryService;

    @PostMapping
    public ResponseEntity<DocumentCategoryModel> register(@RequestBody DocumentCategoryModel model){
        var resp = documentCategoryService.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<DocumentCategoryModel>> recoverAll(){
        return ResponseEntity.status(HttpStatus.OK).body(documentCategoryService.recoverAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<DocumentCategoryModel>> recoverAll(@RequestParam(required = false, name="category") String category, @RequestParam(required = true, name = "entity") EntitiesEnum entity){
        var resp = documentCategoryService.recoverAll(category, entity);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @DeleteMapping("/{category}")
    public ResponseEntity<Void> remove(@RequestParam("category") String category) {
        documentCategoryService.delete(category);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
