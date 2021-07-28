package com.igorcoura.documentmanager.domain.models.company;

import com.igorcoura.documentmanager.domain.entities.Document;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompanyModel {

    private String name;
    private String cnpj;

}
