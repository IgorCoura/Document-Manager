package com.igorcoura.documentmanager.infra.shared;

import java.util.List;
import java.util.stream.Collectors;

import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.models.DocumentModel;

public class DocumentMapper {

    public static Document toEntity(DocumentModel model){
        if(model == null){
            return null;
        }
        return Document.builder()
                .id(model.getId())
                .nameDocument(model.getNameDocument())
                .archivingDate(model.getArchivingDate())
                .entity(model.getEntity())
                .category(model.getCategory())
                .dueDate(model.getDueDate())
                .status(model.getStatus())
                .build();
    }

    public static DocumentModel toModel(Document entity){
        if(entity == null){
            return null;
        }
        return DocumentModel.builder()
                .id(entity.getId())
                .nameDocument(entity.getNameDocument())
                .archivingDate(entity.getArchivingDate())
                .entity(entity.getEntity())
                .category(entity.getCategory())
                .dueDate(entity.getDueDate())
                .status(entity.getStatus())
                .build();
    }

    public  static List<DocumentModel> toModel(List<Document> entity){
        if(entity == null){
            return null;
        }
        return entity.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }

    public  static List<Document> toEntity(List<DocumentModel> model){
        if(model == null){
            return null;
        }
        return model.stream().map(e -> toEntity(e)).collect(Collectors.toList());
    }

}
