package com.igorcoura.documentmanager.domain.models;

import com.igorcoura.documentmanager.domain.entities.BaseEntity;
import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentModel {

    private long id;
    private BaseEntity entity;
    private String nameDocument;
    private DocumentCategory category;
    private DocumentStatus status;
    private LocalDateTime archivingDate;
    private LocalDateTime dueDate;
}
