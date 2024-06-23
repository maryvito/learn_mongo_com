package com.example.learn_mongo_com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnMongoComApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LearnMongoComApplication.class, args);
        var insertAndUpdateDocument = context.getBean(InsertDocument.class);
        insertAndUpdateDocument.run();


    }

}
