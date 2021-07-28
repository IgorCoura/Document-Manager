package com.igorcoura.documentmanager.infra.repository;

import com.igorcoura.documentmanager.domain.entities.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentStatusRepository extends JpaRepository<DocumentStatus, Long> {

}
