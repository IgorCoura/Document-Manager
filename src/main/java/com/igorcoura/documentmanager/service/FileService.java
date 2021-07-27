package com.igorcoura.documentmanager.service;

import com.igorcoura.documentmanager.component.FileComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class FileService {


    @Autowired
    private FileComponent fileComponent;

    public void save(String entity, String id){

        //pegar o tipo da entidade

        //pegar o tipo da entidade e buscar pelo id para returnar o caminho onde o arquivo sera salvo(no caminho tambem tera o nome do arquivo)

        //passar nessa função o arquivo e o caminho onde o arquivo será salvo
        //fileComponent.saveFile(file, "arquivo02.pdf");
    }
}
