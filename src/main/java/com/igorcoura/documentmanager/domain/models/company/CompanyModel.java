package com.igorcoura.documentmanager.domain.models.company;

import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyModel {

    private long id;
    private String name;
    private String cnpj;
    private List<DocumentModel> document;

}
