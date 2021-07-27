package com.igorcoura.documentmanager.domain.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String cnpj;
    @OneToMany
    private List<Document> document;

}
