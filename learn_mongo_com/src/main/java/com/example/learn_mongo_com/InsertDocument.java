package com.example.learn_mongo_com;

import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InsertDocument {

    private final MongoTemplate mongoTemplate;

    public void run() {

        mongoTemplate.getMongoDatabaseFactory().getMongoDatabase().drop();

        MongoCollection<Document> booksCollection = mongoTemplate.getCollection("books");
        MongoCollection<Document> authorsCollection = mongoTemplate.getCollection("authors");
        MongoCollection<Document> genresCollection = mongoTemplate.getCollection("genres");

        var pushkin = new Document().append("_id", 1)
                .append("name", "Puskin");
        var kristi = new Document().append("_id", 2)
                .append("name", "Kristy");
        authorsCollection.insertMany(List.of(pushkin, kristi));

        var roman = new Document().append("_id", 1)
                .append("name", "roman");
        var detectiv = new Document().append("_id", 2)
                .append("name", "detective");
        genresCollection.insertMany(List.of(roman, detectiv));


        var evgenii_onegin = new Document().append("_id", "1")
                .append("name", "Onegin")
                .append("qnt", 1l)
                .append("author", pushkin)
                .append("genre", roman);

        var capitanskaya_dochka = new Document().append("_id", "2")
                .append("name", "Capitan")
                .append("qnt", 1l)
                .append("author", pushkin)
                .append("genre", roman);

        var erkul_pyaro = new Document().append("_id", "3")
                .append("name", "Puaro")
                .append("qnt", 1l)
                .append("author", kristi)
                .append("genre", detectiv);


        booksCollection.insertMany(
                List.of(evgenii_onegin, capitanskaya_dochka, erkul_pyaro));
    }


}
