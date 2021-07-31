package com.igorcoura.documentmanager.domain.models.document;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDocumentCategoryModel {
    private EntitiesEnum entity;
    private String category;

}
