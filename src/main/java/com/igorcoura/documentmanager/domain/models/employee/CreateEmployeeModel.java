package com.igorcoura.documentmanager.domain.models.employee;


import com.igorcoura.documentmanager.domain.entities.Company;
import com.igorcoura.documentmanager.domain.entities.Document;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeModel {

    private String name;
    private String cpf;
    private long idCompany;

}
