package com.igorcoura.documentmanager.infra.repository.custom;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class DocumentStatusCustomRepository {
    @Autowired
    private EntityManager entityManager;


    public List<DocumentStatus> findAll(String status, EntitiesEnum entity){
        String query = "select C from DocumentStatus as C";
        String condition = " where ";
        if(status != null && status != ""){
            query += condition + "C.status = :status";
            condition = " and ";
        }

        if(entity != null){
            query += condition + "C.entity = :entity";
            condition = " and ";
        }
        var q = entityManager.createQuery(query, DocumentStatus.class);

        if(status != null && status != ""){
            q.setParameter("status", status);
        }
        if(entity != null) {
            q.setParameter("entity", entity);
        }
        return q.getResultList();
    }

}
