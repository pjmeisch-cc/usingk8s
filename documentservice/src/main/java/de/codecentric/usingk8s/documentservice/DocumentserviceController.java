/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<DocumentData> insert(@RequestBody DocumentData documentData) {
        return new ResponseEntity<>(repository.save(documentData), HttpStatus.CREATED);
    }

    @GetMapping("/documents")
    public ResponseEntity<Iterable<DocumentData>> list() {
        final Iterable<DocumentData> data = repository.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/documents/clear")
    public ResponseEntity clera() {
        repository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
