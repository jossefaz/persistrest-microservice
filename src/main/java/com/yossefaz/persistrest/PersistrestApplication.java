package com.yossefaz.persistrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistrestApplication {

    public static void main(String[] args) {
        int entier [] [] = {{1,2,3,4,5},{1,2,3,4,5}};
        SpringApplication.run(PersistrestApplication.class, args);
    }

}
