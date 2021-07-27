package com.igorcoura.documentmanager.infra.shared;

import java.util.List;
import java.util.stream.Collectors;

import com.igorcoura.documentmanager.domain.entities.Company;
import com.igorcoura.documentmanager.domain.models.CompanyModel;
import com.igorcoura.documentmanager.domain.models.CreateCompanyModel;
import com.igorcoura.documentmanager.domain.models.DocumentModel;

public class CompanyMapper {


    public static Company toEntity(CreateCompanyModel model){
        return Company.builder()
                .name(model.getName())
                .cnpj(model.getCnpj())
                .build();
    }
    public static Company toEntity(CompanyModel model){
        var company = Company.builder()
                .name(model.getName())
                .cnpj(model.getCnpj())
                .build();
        company.setId(model.getId());
        return company;

    }

    public static CompanyModel toModel(Company entity){
        return CompanyModel.builder()
                .id(entity.getId())
                .cnpj(entity.getCnpj())
                .name(entity.getName())
                .document(DocumentMapper.toModel(entity.getDocument()))
                .build();
    }

    public static List<CompanyModel> toModel(List<Company> entity){
        return entity.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }
}
