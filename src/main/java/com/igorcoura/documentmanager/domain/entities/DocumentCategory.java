package com.igorcoura.documentmanager.domain.entities;


import java.util.List;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String category;
    private String description;
    @OneToMany
    private List<Document> document;
}
