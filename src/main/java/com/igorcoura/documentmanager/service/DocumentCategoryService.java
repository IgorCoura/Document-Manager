package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.models.document.DocumentCategoryModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.infra.repository.DocumentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentCategoryService {

    @Autowired
    private DocumentCategoryRepository documentCategoryRepository;

    public DocumentCategoryModel insert(DocumentCategoryModel model){
        var entity = documentCategoryRepository.save(DocumentCategory.builder().category(model.getCategory()).build());
        return DocumentCategoryModel.builder().category(entity.getCategory()).build();
    }



    public List<DocumentCategoryModel> recoverAll(){
        var entity = documentCategoryRepository.findAll();
        return entity.stream().map(e -> DocumentCategoryModel.builder().category(e.getCategory()).build()).collect(Collectors.toList());
    }

    public void delete(String status){
    }
}
