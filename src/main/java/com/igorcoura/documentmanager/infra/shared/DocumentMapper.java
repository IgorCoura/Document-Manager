package com.igorcoura.documentmanager.infra.shared;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.igorcoura.documentmanager.domain.entities.Document;
import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import com.igorcoura.documentmanager.domain.models.document.*;


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

    public static DocumentDataModel toModel(CreateDocumentDataModel model){
        var doc = DocumentDataModel.builder()
                .category(model.getCategory())
                .id(model.getId())
                .idEntity(model.getIdEntity())
                .nameDocument(model.getNameDocument())
                .status(model.getStatus())
                .build();
        if(model.getArchivingDate() != null){
            var archivingDateString = model.getArchivingDate().split("-");
            var ArchivingDateNumber = Arrays.stream(archivingDateString).map(e-> Integer.parseInt(e)).collect(Collectors.toList());
            doc.setArchivingDate(LocalDate.of(ArchivingDateNumber.get(0),ArchivingDateNumber.get(1),ArchivingDateNumber.get(2)));
        }
        if(model.getDueDate() != null){
            var dueDateString = model.getDueDate().split("-");
            var dueDateNumber = Arrays.stream(dueDateString).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
            doc.setDueDate(LocalDate.of(dueDateNumber.get(0),dueDateNumber.get(1),dueDateNumber.get(2)));
        }
        return doc;
    }

}
