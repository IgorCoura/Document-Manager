package com.igorcoura.documentmanager.infra.repository.custom;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
