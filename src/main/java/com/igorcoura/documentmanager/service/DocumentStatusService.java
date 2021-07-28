package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.models.document.DocumentStatusModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.infra.repository.DocumentStatusRepository;
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

    public DocumentStatusModel insert(DocumentStatusModel model){
        var entity = documentStatusRepository.save(DocumentStatus.builder().status(model.getStatus()).build());
        return DocumentStatusModel.builder().status(entity.getStatus()).build();
    }



    public List<DocumentStatusModel> recoverAll(){
        var entity = documentStatusRepository.findAll();
        return entity.stream().map(e -> DocumentStatusModel.builder().status(e.getStatus()).build()).collect(Collectors.toList());
    }

    public void delete(String status){
    }
}
