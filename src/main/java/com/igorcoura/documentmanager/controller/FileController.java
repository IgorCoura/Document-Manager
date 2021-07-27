package com.igorcoura.documentmanager.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/download")
public class FileController {




    @PostMapping("/{id}")
    public void upload(@RequestParam MultipartFile file, @PathVariable("id") String id){

    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> download(@PathVariable("id") String id){
//        var body = fileComponent.recoverFile(path);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_PDF)
//                .header("Content-disposition", "attachment; filename=arquivo01.pdf")
//                .body(body);
        return ResponseEntity.ok().build();
    }
}
