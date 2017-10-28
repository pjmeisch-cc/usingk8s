/*
 * (c) Copyright 2017 codecentric AG
 */
package de.codecentric.usingk8s.documentservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
public class TestUtils {

    public static byte[] convertObjectToJsonBytes(final Object object) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
