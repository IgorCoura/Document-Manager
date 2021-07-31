package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.CreateDocumentStatusModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.infra.repository.DocumentStatusRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentStatusCustomRepository;
import com.igorcoura.documentmanager.infra.shared.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentStatusService {

    @Autowired
    private DocumentStatusRepository documentStatusRepository;

    @Autowired
    private DocumentStatusCustomRepository documentStatusCustomRepository;

    public DocumentStatusModel insert(CreateDocumentStatusModel model){
        var entity = documentStatusRepository.save(DocumentStatus.builder().status(model.getCategory()).entity(model.getEntity()).build());
        return DocumentStatusModel.builder().status(entity.getStatus()).entity(entity.getEntity()).documentModel(DocumentMapper.toModel(entity.getDocument())).build();
    }



    public List<DocumentStatusModel> recoverAll(){
        var entity = documentStatusRepository.findAll();
        return entity.stream().map(e -> DocumentStatusModel.builder().status(e.getStatus()).documentModel(DocumentMapper.toModel(e.getDocument())).entity(e.getEntity()).build()).collect(Collectors.toList());
    }

    public List<DocumentStatusModel> recoverAll(String status, EntitiesEnum entity){
        var resp = documentStatusCustomRepository.findAll(status, entity);
        return resp.stream().map(e -> DocumentStatusModel.builder().status(e.getStatus()).entity(e.getEntity()).documentModel(DocumentMapper.toModel(e.getDocument())).build()).collect(Collectors.toList());
    }

    public void delete(String status){
    }
}
