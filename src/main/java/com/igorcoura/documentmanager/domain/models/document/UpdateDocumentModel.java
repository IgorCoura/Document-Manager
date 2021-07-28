package com.igorcoura.documentmanager.domain.models.document;

import com.igorcoura.documentmanager.domain.entities.BaseEntity;
import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDocumentModel {

    private long id;
    private long idEntity;
    private String nameDocument;
    private String category;
    private String status;
    private LocalDate archivingDate = LocalDate.MIN;
    private LocalDate dueDate = LocalDate.MIN;

}
