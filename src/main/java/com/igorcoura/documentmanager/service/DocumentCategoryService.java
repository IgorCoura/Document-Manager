package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.CreateDocumentCategoryModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentCategoryModel;
import com.igorcoura.documentmanager.infra.repository.DocumentCategoryRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentCategoryCustomRepository;
import com.igorcoura.documentmanager.infra.shared.DocumentMapper;
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

    public DocumentCategoryModel insert(CreateDocumentCategoryModel model){
        var category = new DocumentCategory();
        category.setCategory(model.getCategory());
        category.setEntity(model.getEntity());
        var entity = documentCategoryRepository.save(category);
        return DocumentCategoryModel.builder().category(entity.getCategory()).entity(entity.getEntity()).documentModel(DocumentMapper.toModel(entity.getDocument())).build();
    }



    public List<DocumentCategoryModel> recoverAll(){
        var entity = documentCategoryRepository.findAll();
        return entity.stream().map(e -> DocumentCategoryModel.builder().category(e.getCategory()).entity(e.getEntity()).documentModel(DocumentMapper.toModel(e.getDocument())).build()).collect(Collectors.toList());
    }

    public List<DocumentCategoryModel> recoverAll(String category, EntitiesEnum entity){
        var resp = documentCategoryCustomRepository.findAll(category, entity);
        return resp.stream().map(e -> DocumentCategoryModel.builder().category(e.getCategory()).entity(e.getEntity()).documentModel(DocumentMapper.toModel(e.getDocument())).build()).collect(Collectors.toList());
    }

    public void delete(String category){

    }
}
