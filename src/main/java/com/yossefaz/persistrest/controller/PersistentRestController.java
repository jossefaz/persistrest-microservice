package com.yossefaz.persistrest.controller;

import com.yossefaz.persistrest.model.PersistentRestService;
import com.yossefaz.persistrest.model.RestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("persistentrest")
public class PersistentRestController  {

    @Autowired
    PersistentRestService persistentRestService;

//    @Autowired
//    RestClient restClient;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void handlePost(@RequestBody RestEntity restEntity) {
            persistentRestService.save(restEntity);
    }

    @GetMapping
    public ResponseEntity<List<RestEntity>> performAllRequest() {
        return new ResponseEntity(StreamSupport.stream( persistentRestService.findAll().spliterator(), false), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void performAllRequest(@PathVariable UUID id) {
        persistentRestService.deleteById(id);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        performAllRequest();
//    }
}
