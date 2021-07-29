package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.*;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
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

    public DocumentModel insert(CreateDocumentModel model) throws Exception {
        var entity = DocumentMapper.toEntity(model);

        var baseEntity = baseEntityRepository.getById(model.getIdEntity());
        var status =documentStatusCustomRepository.findByStatus(model.getStatus());
        var category= documentCategoryCustomRepository.findByCategory(model.getCategory());

        if(baseEntity.toString().contains("Company")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else if(baseEntity.toString().contains("CompanyWorks")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else if(baseEntity.toString().contains("Employee")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else{
            throw  new Exception("Entity erro");
        }

        entity.setCategory(category);
        entity.setStatus(status);
        entity.setEntity(baseEntity);

        entity.setPath(entity.getEntity().getId()+"/"+entity.getNameDocument());
        var resp = DocumentMapper.toModel(documentRepository.save(entity));
        resp.setFileLink("/api/file/"+entity.getId());
        return resp;
    }

    public DocumentModel update(UpdateDocumentModel model) throws Exception {
        var entity = DocumentMapper.toEntity(model);

        var baseEntity = baseEntityRepository.getById(model.getIdEntity());
        var status =documentStatusCustomRepository.findByStatus(model.getStatus());
        var category= documentCategoryCustomRepository.findByCategory(model.getCategory());

        if(baseEntity.toString().contains("Company")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else if(baseEntity.toString().contains("CompanyWorks")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else if(baseEntity.toString().contains("Employee")){
            if(status.getEntity() != EntitiesEnum.Company || category.getEntity() != EntitiesEnum.Company ){
                throw  new Exception("Category or status does not belong to that entity.");
            }
        }
        else{
            throw  new Exception("Entity erro");
        }

        entity.setCategory(category);
        entity.setStatus(status);
        entity.setEntity(baseEntity);

        entity.setPath(entity.getEntity().getId()+"/"+entity.getNameDocument());
        var resp = DocumentMapper.toModel(documentRepository.save(entity));
        resp.setFileLink("/api/file/"+entity.getId());
        return resp;
    }

    public DocumentModel recover(long id){
        var entity = documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Document with id = "+id+", not found"));
        var resp =DocumentMapper.toModel(entity);
        resp.setFileLink("/api/file/"+entity.getId());
        return resp;
    }

    public List<DocumentModel> recoverAll(){
        var entity = documentRepository.findAll();
        var resp =DocumentMapper.toModel(entity);
        resp.stream().forEach(m -> m.setFileLink("/api/file/"+m.getId()));
        return resp;
    }

    public void delete(long id){
        documentRepository.deleteById(id);
    }
}
