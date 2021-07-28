package com.igorcoura.documentmanager.infra.repository.custom;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DocumentStatusCustomRepository {
    @Autowired
    private EntityManager entityManager;

    public DocumentStatus findByStatus(String status){
        String query = "select C from DocumentStatus as C where C.status = :status";
        var q = entityManager.createQuery(query, DocumentStatus.class);
        q.setParameter("status", status);
        return q.getSingleResult();
    }

}
