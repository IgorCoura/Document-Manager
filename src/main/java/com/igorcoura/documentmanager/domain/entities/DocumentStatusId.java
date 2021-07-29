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
public class DocumentStatusId implements Serializable {
    private String status;
    private EntitiesEnum entity;
}