package com.igorcoura.documentmanager.infra.repository;

import com.igorcoura.documentmanager.domain.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
