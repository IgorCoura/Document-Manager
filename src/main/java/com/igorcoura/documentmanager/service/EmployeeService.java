package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.entities.Company;
import com.igorcoura.documentmanager.domain.models.company.CompanyModel;
import com.igorcoura.documentmanager.domain.models.company.CreateCompanyModel;
import com.igorcoura.documentmanager.domain.models.employee.CreateEmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.EmployeeModel;
import com.igorcoura.documentmanager.domain.models.employee.UpdateEmployeeModel;
import com.igorcoura.documentmanager.infra.repository.CompanyRepository;
import com.igorcoura.documentmanager.infra.repository.EmployeeRepository;
import com.igorcoura.documentmanager.infra.shared.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public EmployeeModel insert(CreateEmployeeModel model){
        var entity = EmployeeMapper.toEntity(model);
        entity.setCompany(companyRepository.getById(model.getIdCompany()));
        return EmployeeMapper.toModel(employeeRepository.save(entity));
    }

    public EmployeeModel update(UpdateEmployeeModel model){
        var entity = EmployeeMapper.toEntity(model);
        entity.setCompany(companyRepository.getById(model.getIdCompany()));
        return EmployeeMapper.toModel(employeeRepository.save(entity));
    }

    public List<EmployeeModel> recoverAll(){
        var entity = employeeRepository.findAll();
        return EmployeeMapper.toModel(entity);
    }

    public EmployeeModel recover(Long id){
        var entity = employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Company with "+id+", not found"));
        return EmployeeMapper.toModel(entity);
    }

    public void delete(long id){
        employeeRepository.deleteById(id);
    }
}
