/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
@RestController
public class DocumentserviceController {

    private final DocumentDataRepository repository;

    @Autowired
    public DocumentserviceController(DocumentDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/document")
    public ResponseEntity<DocumentData> insert(DocumentData documentData) {
        final DocumentData data = repository.save(documentData);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/documents")
    public ResponseEntity<Iterable<DocumentData>> list() {
        final Iterable<DocumentData> data = repository.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
