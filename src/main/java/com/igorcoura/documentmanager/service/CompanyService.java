package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.domain.models.company.UpdateCompanyModel;
import com.igorcoura.documentmanager.infra.repository.CompanyRepository;
import com.igorcoura.documentmanager.domain.models.company.CompanyModel;
import com.igorcoura.documentmanager.domain.models.company.CreateCompanyModel;
import com.igorcoura.documentmanager.infra.shared.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyModel insert(CreateCompanyModel companyModel){
        var entity = companyRepository.save(CompanyMapper.toEntity(companyModel));
        System.out.println();
        return CompanyMapper.toModel(entity);
    }

    public CompanyModel update(UpdateCompanyModel companyModel){
        var entity = companyRepository.save(CompanyMapper.toEntity(companyModel));
        return CompanyMapper.toModel(entity);
    }

    public List<CompanyModel> recoverAll(){
        var entity = companyRepository.findAll();
        return CompanyMapper.toModel(entity);
    }

    public CompanyModel recover(Long id){
        var entity = companyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Company with "+id+", not found"));
        return CompanyMapper.toModel(entity);
    }

    public void delete(long id){
        companyRepository.deleteById(id);
    }
}
