package com.igorcoura.documentmanager.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String status;
    private String description;
    @OneToMany
    private List<Document> document;
}
