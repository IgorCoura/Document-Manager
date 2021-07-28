package com.igorcoura.documentmanager.infra.repository;

import com.igorcoura.documentmanager.domain.entities.DocumentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory, Long> {
}
