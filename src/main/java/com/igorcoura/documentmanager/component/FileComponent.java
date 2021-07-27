package com.igorcoura.documentmanager.component;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileComponent {

    private String root = System.getProperty("user.dir") + "/file";

    public void saveFile(MultipartFile file, String path) {
        Path filePath = Paths.get(this.root, path);
        //Path filePath = directoryPath.resolve(fileName);
        try {
            //Files.createDirectories(directoryPath);
            file.transferTo(filePath.toFile());

        } catch (IOException e) {
            throw new RuntimeException("Problems trying to save file: " + e.getMessage());
        }
    }

    public InputStreamResource recoverFile(String path){
        Path filePath = Paths.get(root, path);
        try{
            var f = new FileInputStream(filePath.toString());
            return new InputStreamResource(f);
        }catch (FileNotFoundException e){
            throw new RuntimeException("Path "+ path +"not found. Error: " + e.getMessage());
        }

    }


}
