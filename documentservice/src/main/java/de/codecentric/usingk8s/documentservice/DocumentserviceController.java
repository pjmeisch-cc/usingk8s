/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @NotNull
    @PostMapping("/document")
    public ResponseEntity<DocumentData> save(@NotNull @RequestBody DocumentData documentData) {
        return new ResponseEntity<>(repository.save(documentData), HttpStatus.OK);
    }

    @NotNull
    @GetMapping("/documents")
    public ResponseEntity<Iterable<DocumentData>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @NotNull
    @PostMapping("/documents/clear")
    public ResponseEntity clear() {
        repository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @NotNull
    @GetMapping("/document/search")
    public ResponseEntity<Iterable<DocumentData>> search(@RequestParam("q") String s) {
        return new ResponseEntity<>(repository.findByTitleContainingOrContentContaining(s, s), HttpStatus.OK);
    }
}
