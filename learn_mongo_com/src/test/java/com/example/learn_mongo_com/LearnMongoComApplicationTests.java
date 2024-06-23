package com.example.learn_mongo_com;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class LearnMongoComApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    MongoCollection<Document> booksCollection;

    @BeforeEach
    void beforeEach(){
       booksCollection = mongoTemplate.getCollection("books");

    }

    @Test
    void findDocument() {

        FindIterable<Document> documents = booksCollection.find(
                Filters.and(Filters.gte("_id", "1"),
                        Filters.eq("name", "Capitan")));
        MongoCursor<Document> cursor = documents.iterator();
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    @Test
    void updateDocument(){
        Bson query = Filters.eq("name", "Capitan");
        Bson updates = Updates.combine(Updates.set("name", "Capitan1"),
                Updates.inc("qnt", 10));
        UpdateResult updateResult = booksCollection.updateOne(query, updates);
    }



}
