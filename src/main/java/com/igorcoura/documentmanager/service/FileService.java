package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.component.FileComponent;
import com.igorcoura.documentmanager.domain.entities.BaseEntity;
import com.igorcoura.documentmanager.infra.repository.BaseEntityRepository;
import com.igorcoura.documentmanager.infra.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;

@Service
public class FileService {


    @Autowired
    private FileComponent fileComponent;

    @Autowired
    private DocumentRepository documentRepository;

    public void save(MultipartFile file, long id){
        var document = documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Document with id = "+id+", not found"));
        fileComponent.saveFile(file, document.getPath());
    }

    public InputStreamResource recover(long id){
        var document = documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Document with id = "+id+", not found"));
        return fileComponent.recoverFile(document.getPath());
    }


}
