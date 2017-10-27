/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * The data store in the repository. It is named "..Data", because "Document" is used by the annotation.
 *
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
@Document(indexName = "documents")
public class DocumentData {
    /** the id. */
    @Id
    private String id;

    /** the doc's title */
    private String title;

    /** the doc's content */
    private String content;
}
