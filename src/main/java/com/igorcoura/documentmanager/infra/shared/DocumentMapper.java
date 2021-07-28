package com.igorcoura.documentmanager.infra.shared;

import java.util.List;
import java.util.stream.Collectors;

import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.models.document.CreateDocumentModel;
import com.igorcoura.documentmanager.domain.models.document.DocumentModel;
import com.igorcoura.documentmanager.domain.models.document.UpdateDocumentModel;


public class DocumentMapper {

    public static Document toEntity(CreateDocumentModel model){
        return Document.builder()
                .nameDocument(model.getNameDocument())
                .archivingDate(model.getArchivingDate())
                .dueDate(model.getDueDate())
                .build();
    }

    public static Document toEntity(UpdateDocumentModel model){
        return Document.builder()
                .id(model.getId())
                .nameDocument(model.getNameDocument())
                .archivingDate(model.getArchivingDate())
                .dueDate(model.getDueDate())
                .build();
    }

    public static DocumentModel toModel(Document entity){
        if(entity == null){
            return null;
        }
        return DocumentModel.builder()
                .id(entity.getId())
                .idEntity(entity.getEntity().getId())
                .nameDocument(entity.getNameDocument())
                .category(entity.getCategory().getCategory())
                .status(entity.getStatus().getStatus())
                .archivingDate(entity.getArchivingDate())
                .dueDate(entity.getDueDate())
                .build();
    }

    public static List<DocumentModel> toModel(List<Document> entity){
        if(entity == null){
            return null;
        }
        return entity.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }

}
