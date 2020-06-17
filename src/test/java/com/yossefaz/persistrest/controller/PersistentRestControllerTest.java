package com.yossefaz.persistrest.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yossefaz.persistrest.model.PersistentRestService;
import com.yossefaz.persistrest.model.RestEntity;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersistentRestController.class)
class PersistentRestControllerTest {

    @MockBean
    PersistentRestService persistentRestService;

    @Autowired
    MockMvc mockMvc;


    RestEntity validRestEntity;

    @BeforeEach
    public void setUp()  throws JsonParseException, IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        JsonNode actualObj = mapper.readTree(parser);
        validRestEntity = RestEntity.builder()
                .id(UUID.randomUUID())
                .headers(null)
                .url("http://dummies.com")
                .method(HttpMethod.POST)
                .payload(actualObj)
                .build();
    }


    @Test
    void createRequest() throws Exception {
        //given
        RestEntity restEntity = validRestEntity;
        restEntity.setId(null);
        RestEntity savedDto = RestEntity.builder().id(UUID.randomUUID()).url("http://test.com").payload(validRestEntity.getPayload()).build();
        ObjectMapper mapper = new ObjectMapper();
        String beerDtoJson = mapper.writeValueAsString(restEntity);
        given(persistentRestService.save(any())).willReturn(savedDto);
        mockMvc.perform(post("/api/v1/persistentrest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllRequest() {
    }

    @Test
    void deleteRequest() {
    }
}