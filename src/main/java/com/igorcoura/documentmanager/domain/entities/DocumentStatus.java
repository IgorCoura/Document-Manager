package com.igorcoura.documentmanager.domain.entities;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(DocumentStatusId.class)
public class DocumentStatus {

    @Id
    private String status;
    @Id
    private EntitiesEnum entity;
    @OneToMany(mappedBy = "status")
    private List<Document> document;
}
