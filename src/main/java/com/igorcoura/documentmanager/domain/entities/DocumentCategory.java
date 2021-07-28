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
    private String category;
    @OneToMany
    private List<Document> document;
}
