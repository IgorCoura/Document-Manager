package com.igorcoura.documentmanager.domain.models.employee;

import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeModel {

    private long id;
    private String name;
    private String cpf;
    private long idCompany;
    private List<DocumentModel> document;

}
