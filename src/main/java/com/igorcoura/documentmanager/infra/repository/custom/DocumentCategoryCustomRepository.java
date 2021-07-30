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

    public List<DocumentCategory> findAll(String category, EntitiesEnum entity){
        String query = "select C from DocumentCategory as C";
        String condition = " where ";
        if(category != null && category != ""){
            query += condition + "C.category = :category";
            condition = " and ";
        }
        if(entity != null){
            query += condition + "C.entity = :entity";
            condition =" and ";
        }

        var q = entityManager.createQuery(query, DocumentCategory.class);

        if(category != null && category != ""){
            q.setParameter("category", category);
        }
        if(entity != null){
            q.setParameter("entity", entity);
        }
        return q.getResultList();
    }

}
