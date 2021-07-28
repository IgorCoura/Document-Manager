package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.models.document.CreateDocumentModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import com.igorcoura.documentmanager.domain.models.document.UpdateDocumentModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.infra.repository.BaseEntityRepository;
import com.igorcoura.documentmanager.infra.repository.DocumentCategoryRepository;
import com.igorcoura.documentmanager.infra.repository.DocumentRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentCategoryCustomRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentStatusCustomRepository;
import com.igorcoura.documentmanager.infra.shared.DocumentMapper;
import com.igorcoura.documentmanager.infra.shared.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentCategoryCustomRepository documentCategoryCustomRepository;

    @Autowired
    private DocumentStatusCustomRepository documentStatusCustomRepository;

    @Autowired
    private BaseEntityRepository baseEntityRepository;

    public DocumentModel insert(CreateDocumentModel model){
        var enitty = DocumentMapper.toEntity(model);
        enitty.setCategory(documentCategoryCustomRepository.findByCategory(model.getCategory()));
        enitty.setStatus(documentStatusCustomRepository.findByStatus(model.getStatus()));
        enitty.setEntity(baseEntityRepository.getById(model.getIdEntity()));
        var resp = documentRepository.save(enitty);
        return DocumentMapper.toModel(resp);

    }



}
