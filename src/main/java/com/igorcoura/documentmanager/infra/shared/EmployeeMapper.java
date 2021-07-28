package com.igorcoura.documentmanager.infra.shared;

import com.igorcoura.documentmanager.domain.entities.Employee;
import com.igorcoura.documentmanager.domain.models.company.UpdateCompanyModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static Employee toEntity(CreateEmployeeModel model){
        return Employee.builder()
                .name(model.getName())
                .cpf(model.getCpf())
                .build();
    }

    public static Employee toEntity(UpdateEmployeeModel model){
        var employee = Employee.builder()
                .name(model.getName())
                .cpf(model.getCpf())
                .build();
        employee.setId(model.getId());
        return employee;
    }

    public static EmployeeModel toModel(Employee entity){
        return EmployeeModel.builder()
                .id(entity.getId())
                .idCompany(entity.getCompany().getId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .document(DocumentMapper.toModel(entity.getDocument()))
                .build();
    }

    public static List<EmployeeModel> toModel(List<Employee> entity){
        return entity.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }

}
