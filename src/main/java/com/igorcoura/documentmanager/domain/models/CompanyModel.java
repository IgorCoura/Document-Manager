package com.igorcoura.documentmanager.domain.models;

import com.igorcoura.documentmanager.domain.entities.Document;
import lombok.*;

import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.OneToMany;
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
