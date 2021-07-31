package com.igorcoura.documentmanager.domain.entities;


import lombok.*;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyWorks extends BaseEntity{

    @ManyToOne
    private Company company;
    private String name;
    private String description;
    @OneToMany(mappedBy = "entity")
    private List<Document> document;
}
