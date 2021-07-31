package com.igorcoura.documentmanager.domain.entities;


import java.io.Serializable;
import java.util.List;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(DocumentCategoryId.class)
public class DocumentCategory {

    @Id
    private String category;
    @Id
    private EntitiesEnum entity;
    @OneToMany(mappedBy = "category")
    private List<Document> document;
}


