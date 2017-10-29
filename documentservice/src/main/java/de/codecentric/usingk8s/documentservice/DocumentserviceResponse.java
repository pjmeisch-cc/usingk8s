/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
public class DocumentserviceResponse {
    private final List<DocumentData> documents = new ArrayList<>();
    private final String message;

    public DocumentserviceResponse(String message, @NotNull Iterable<DocumentData> documentDatas) {
        this.message = message;
        StreamSupport.stream(documentDatas.spliterator(), false)
                .forEach(documents::add);

    }

    public DocumentserviceResponse(@NotNull String message, DocumentData... documentsArg) {
        this.message = message;
        if (documentsArg != null) {
            Collections.addAll(documents, documentsArg);
        }
    }

    public List<DocumentData> getDocuments() {
        return documents;
    }

    public String getMessage() {
        return message;
    }
}
