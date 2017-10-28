package de.codecentric.usingk8s.documentservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static de.codecentric.usingk8s.documentservice.DocumentDataBuilder.aDocumentData;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author P.J. Meisch (peter-josef.meisch@codecentric.de)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DocumentserviceController.class)
public class DocumentserviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DocumentDataRepository repository;

    @Test
    public void saveDocument() throws Exception {
        DocumentData documentToSave = aDocumentData().withTitle("title").withContent("content").build();
        DocumentData savedDocument = aDocumentData().withId("4711").withTitle("title").withContent("content").build();

        when(repository.save(documentToSave))
                .thenReturn(savedDocument);

        mockMvc.perform(post("/document")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonBytes(documentToSave)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(savedDocument.getId()))
                .andExpect(jsonPath("$.title").value(savedDocument.getTitle()))
                .andExpect(jsonPath("$.content").value(savedDocument.getContent()))
        ;
        verify(repository).save(documentToSave);
    }

    @Test
    public void allDocuments() throws Exception {
        final DocumentData data1 = aDocumentData().withId("id1").withTitle("title 1").withContent("content1").build();
        final DocumentData data2 = aDocumentData().withId("id2").withTitle("title 2").withContent("content2").build();

        when(repository.findAll())
                .thenReturn(Arrays.asList(data1, data2));

        mockMvc.perform(get("/documents"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(data1.getId()))
                .andExpect(jsonPath("$[0].title").value(data1.getTitle()))
                .andExpect(jsonPath("$[0].content").value(data1.getContent()))
                .andExpect(jsonPath("$[1].id").value(data2.getId()))
                .andExpect(jsonPath("$[1].title").value(data2.getTitle()))
                .andExpect(jsonPath("$[1].content").value(data2.getContent()))
        ;

        verify(repository).findAll();
    }

    @Test
    public void clearRepository() throws Exception {
        mockMvc.perform(post("/documents/clear")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));

        verify(repository).deleteAll();
    }

    @Test
    public void search() throws Exception {
        final DocumentData data1 = aDocumentData().withId("id1").withTitle("title 1").withContent("content1").build();
        final DocumentData data2 = aDocumentData().withId("id2").withTitle("title 2").withContent("content2").build();
        String s = "2";

        when(repository.findByTitleContainingOrContentContaining(s, s))
                .thenReturn(Collections.singletonList(data2));

        mockMvc.perform(get("/document/search")
                .param("q", s))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(data2.getId()))
                .andExpect(jsonPath("$[0].title").value(data2.getTitle()))
                .andExpect(jsonPath("$[0].content").value(data2.getContent()))
        ;

        verify(repository).findByTitleContainingOrContentContaining(s, s);
    }
}
