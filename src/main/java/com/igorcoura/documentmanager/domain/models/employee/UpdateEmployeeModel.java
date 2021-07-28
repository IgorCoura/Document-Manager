package com.igorcoura.documentmanager.domain.models.employee;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateEmployeeModel {

    private long id;
    private String name;
    private String cpf;
    private long idCompany;

}
