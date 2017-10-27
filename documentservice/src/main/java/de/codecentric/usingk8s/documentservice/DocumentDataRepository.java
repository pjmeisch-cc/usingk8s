/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
public interface DocumentDataRepository extends ElasticsearchCrudRepository<DocumentData, String> {
}
