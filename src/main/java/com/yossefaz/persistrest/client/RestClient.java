package com.yossefaz.persistrest.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yossefaz.persistrest.model.RestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

//@Slf4j
//@Component
//@Data
//@Builder
public class RestClient {

//    private RestEntity restEntity;
//    private RestTemplate restTemplate;
//
//    public void makeRequest() {
//        HttpEntity<String> request = new HttpEntity<String>(restEntity.getPayload().toString(), convertJsonToMap(restEntity.getHeaders()));
//        ResponseEntity<String> result = restTemplate.exchange(restEntity.getUrl(), restEntity.getMethod(), request, String.class);
//        log.info(String.valueOf(result));
//    }
//
//    private static MultiValueMap<String, String> convertJsonToMap(JsonNode json) {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.convertValue(json, new TypeReference<MultiValueMap<String, String>>(){});
//    }
}
