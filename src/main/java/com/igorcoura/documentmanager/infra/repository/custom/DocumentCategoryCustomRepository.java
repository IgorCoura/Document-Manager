package com.igorcoura.documentmanager.infra.repository.custom;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Repository
public class DocumentCategoryCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public DocumentCategory findByCategory(String category){
        String query = "select C from DocumentCategory as C where C.category = :category";
        var q = entityManager.createQuery(query, DocumentCategory.class);
        q.setParameter("category", category);
        return q.getSingleResult();
    }

    public List<DocumentCategory> findAllByEntity(EntitiesEnum entity){
        String query = "select C from DocumentCategory as C where C.entity = :entity";
        var q = entityManager.createQuery(query, DocumentCategory.class);
        q.setParameter("entity", entity);
        return q.getResultList();
    }

}
