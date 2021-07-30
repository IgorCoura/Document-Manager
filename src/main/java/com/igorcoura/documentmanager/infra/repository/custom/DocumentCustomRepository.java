package com.igorcoura.documentmanager.infra.repository.custom;

import com.igorcoura.documentmanager.domain.entities.BaseEntity;
import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.DocumentDataModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import com.igorcoura.documentmanager.infra.repository.BaseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class DocumentCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BaseEntityRepository baseEntityRepository;

    @Autowired
    private DocumentStatusCustomRepository documentStatusCustomRepository;

    @Autowired
    private  DocumentCategoryCustomRepository documentCategoryCustomRepository;


    public List<Document> findAll(DocumentDataModel model) {
        String query = "select C from Document as C";
        String condition = " where ";

        DocumentCategory category = null;
        DocumentStatus status = null;

        var entity = model.getIdEntity() != null ? baseEntityRepository.getById(model.getIdEntity()): null;
        if(model.getEntityType() != null){
            status =  model.getStatus() != null ? documentStatusCustomRepository.findAll(model.getStatus(), model.getEntityType()).get(0) : null;
            category=  model.getCategory() != null ? documentCategoryCustomRepository.findAll(model.getCategory(), model.getEntityType()).get(0): null;
        }

        if(model.getId() != null){
            query += condition + "C.id = :id";
            condition = " and ";
        }
        if(entity != null){
            query += condition + "C.entity = :entity";
            condition = " and ";
        }
        if(model.getNameDocument() != null){
            query += condition + "C.nameDocument = :nameDocument";
            condition = " and ";
        }
        if(category != null){
            query += condition + "C.category = :category";
            condition = " and ";
        }
        if(status != null){
            query += condition + "C.status = :status";
            condition = " and ";
        }
        if(model.getArchivingDate() != null){
            query += condition + "C.archivingDate = :archivingDate";
            condition = " and ";
        }
        if(model.getDueDate() != null){
            query += condition + "C.dueDate = :dueDate";
            condition = " and ";
        }

        var q = entityManager.createQuery(query, Document.class);

        if(model.getId() != null){
            q.setParameter("id", model.getId());
        }
        if(entity != null){
            q.setParameter("entity", entity);
        }
        if(model.getNameDocument() != null){
            q.setParameter("nameDocument", model.getNameDocument());
        }
        if(category != null){
            q.setParameter("category", category);
        }
        if(status != null){
            q.setParameter("status", status);
        }
        if(model.getArchivingDate() != null){
            q.setParameter("archivingDate", model.getArchivingDate());
        }
        if(model.getDueDate() != null){
            q.setParameter("dueDate", model.getDueDate());
        }
        return q.getResultList();
    }

}
