package com.igorcoura.documentmanager.controller;

import com.igorcoura.documentmanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {


    @Autowired
    private FileService fileService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> upload(@RequestParam MultipartFile file, @PathVariable("id") long id){
        fileService.save(file, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> download(@PathVariable("id") long id){
        var body = fileService.recover(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .header("Content-disposition", "attachment; filename="+id)
                .body(body);
    }
}
