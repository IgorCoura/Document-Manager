package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.infra.repository.DocumentStatusRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentCategoryCustomRepository;
import com.igorcoura.documentmanager.infra.repository.custom.DocumentStatusCustomRepository;
import com.igorcoura.documentmanager.infra.shared.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentStatusService {

    @Autowired
    private DocumentStatusRepository documentStatusRepository;

    @Autowired
    private DocumentStatusCustomRepository documentStatusCustomRepository;

    public DocumentStatusModel insert(DocumentStatusModel model){
        var status = new DocumentStatus();
        status.setStatus(model.getStatus());
        status.setEntity(model.getEntity());
        var entity = documentStatusRepository.save(status);
        return DocumentStatusModel.builder().status(entity.getStatus()).entity(entity.getEntity()).build();
    }



    public List<DocumentStatusModel> recoverAll(){
        var entity = documentStatusRepository.findAll();
        return entity.stream().map(e -> DocumentStatusModel.builder().status(e.getStatus()).entity(e.getEntity()).build()).collect(Collectors.toList());
    }

    public List<DocumentStatusModel> recoverAllByEntity(EntitiesEnum entity){
        var resp = documentStatusCustomRepository.findAllByEntity(entity);
        return resp.stream().map(e -> DocumentStatusModel.builder().status(e.getStatus()).entity(e.getEntity()).build()).collect(Collectors.toList());
    }

    public void delete(String status){
        var entity = documentStatusCustomRepository.findByStatus(status);
        documentStatusRepository.delete(entity);
    }
}
