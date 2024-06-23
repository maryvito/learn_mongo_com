package com.example.learn_mongo_com;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateDocuments {

    private final MongoTemplate mongoTemplate;

    public void run(){

        MongoCollection<Document> booksCollection = mongoTemplate.getCollection("books");
        MongoCollection<Document> authorsCollection = mongoTemplate.getCollection("authors");
        MongoCollection<Document> genresCollection = mongoTemplate.getCollection("genres");

        Bson query = Filters.eq("name", "Capitan");
        Bson updates = Updates.combine(Updates.set("name", "Capitan1"),
                Updates.inc("_id", 10));
        UpdateResult updateResult = booksCollection.updateOne(query, updates);
    }
}
