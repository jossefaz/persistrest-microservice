package com.yossefaz.persistrest.controller;


import com.yossefaz.persistrest.model.PersistentRestService;
import com.yossefaz.persistrest.model.RestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("persistentrest")
public class PersistentRestController {

    @Autowired
    PersistentRestService persistentRestService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void handlePost(@RequestBody RestEntity restEntity) {
            persistentRestService.save(restEntity);
    }

}
