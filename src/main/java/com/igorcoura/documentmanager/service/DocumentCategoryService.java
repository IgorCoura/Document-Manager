package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.DocumentCategoryModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.infra.repository.DocumentCategoryRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentCategoryCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentCategoryService {

    @Autowired
    private DocumentCategoryRepository documentCategoryRepository;

    @Autowired
    private DocumentCategoryCustomRepository documentCategoryCustomRepository;

    public DocumentCategoryModel insert(DocumentCategoryModel model){
        var category = new DocumentCategory();
        category.setCategory(model.getCategory());
        category.setEntity(model.getEntity());
        var entity = documentCategoryRepository.save(category);
        return DocumentCategoryModel.builder().category(entity.getCategory()).entity(entity.getEntity()).build();
    }



    public List<DocumentCategoryModel> recoverAll(){
        var entity = documentCategoryRepository.findAll();
        return entity.stream().map(e -> DocumentCategoryModel.builder().category(e.getCategory()).entity(e.getEntity()).build()).collect(Collectors.toList());
    }

    public List<DocumentCategoryModel> recoverAllByEntity(EntitiesEnum entity){
        var resp = documentCategoryCustomRepository.findAllByEntity(entity);
        return resp.stream().map(e -> DocumentCategoryModel.builder().category(e.getCategory()).entity(e.getEntity()).build()).collect(Collectors.toList());
    }

    public void delete(String category){
        var entity = documentCategoryCustomRepository.findByCategory(category);
        documentCategoryRepository.delete(entity);
    }
}
