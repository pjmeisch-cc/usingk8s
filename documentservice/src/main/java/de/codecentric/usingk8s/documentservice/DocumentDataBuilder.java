/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
public final class DocumentDataBuilder {
    private String id;
    private String title;
    private String content;

    private DocumentDataBuilder() {
    }

    public static DocumentDataBuilder aDocumentData() {
        return new DocumentDataBuilder();
    }

    public DocumentDataBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public DocumentDataBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DocumentDataBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public DocumentData build() {
        DocumentData documentData = new DocumentData();
        documentData.setId(id);
        documentData.setTitle(title);
        documentData.setContent(content);
        return documentData;
    }
}
