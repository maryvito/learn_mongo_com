package com.example.learn_mongo_com;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class FindDocumentWithoutSpringBoot {

    public void run(){

        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")){
            MongoDatabase database = mongoClient.getDatabase("library_db");
            MongoCollection<Document> collection = database.getCollection("books");


            FindIterable<Document> documents = collection.find(
                    Filters.and(Filters.gte("_id", "1"),
                            Filters.eq("name", "Capitan")));
            MongoCursor<Document> cursor = documents.iterator();
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            Document first = collection.find(
                    Filters.and(Filters.gte("_id", 1),
                            Filters.eq("name", "Capitan"))).first();


        }
    }
}
