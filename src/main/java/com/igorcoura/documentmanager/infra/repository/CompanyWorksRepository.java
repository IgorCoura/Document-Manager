package com.igorcoura.documentmanager.infra.repository;

import com.igorcoura.documentmanager.domain.entities.CompanyWorks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyWorksRepository extends JpaRepository<CompanyWorks,Long> {
}
