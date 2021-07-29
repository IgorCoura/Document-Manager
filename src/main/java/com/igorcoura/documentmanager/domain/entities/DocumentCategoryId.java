package com.igorcoura.documentmanager.domain.entities;

import com.igorcoura.documentmanager.domain.enums.EntitiesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCategoryId implements Serializable {

    private String category;
    private EntitiesEnum entity;

}
