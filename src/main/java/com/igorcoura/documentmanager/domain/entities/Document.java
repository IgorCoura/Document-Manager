package com.igorcoura.documentmanager.domain.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String path;
    private String nameDocument;
    @ManyToOne
    private BaseEntity entity;
    @ManyToOne
    private DocumentCategory category;
    @ManyToOne
    private DocumentStatus status;
    private LocalDate archivingDate;
    private LocalDate dueDate;

}
