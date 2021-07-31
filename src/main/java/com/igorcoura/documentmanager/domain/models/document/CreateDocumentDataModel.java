package com.igorcoura.documentmanager.domain.models.document;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateDocumentDataModel {

    private Long id;
    private Long idEntity;
    private String nameDocument;
    private String category;
    private String status;
    private String archivingDate;
    private String dueDate;

}
