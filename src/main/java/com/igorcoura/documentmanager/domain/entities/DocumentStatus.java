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
    private String status;
    @OneToMany
    private List<Document> document;
}
