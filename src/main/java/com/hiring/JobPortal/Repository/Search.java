package com.hiring.JobPortal.Repository;

import com.hiring.JobPortal.Model.PostModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Search implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;


    @Override
    public List<PostModel> search(String token) {
        List<PostModel> searchResult = new ArrayList<>();
        MongoDatabase database = client.getDatabase("Hiring");
        MongoCollection<Document> collection = database.getCollection("Job");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", token)
                                .append("path", Arrays.asList("profile", "tech", "exp", "dec"))))));
        result.forEach(doc -> searchResult.add(converter.read(PostModel.class, doc)));
        return searchResult;
    }
}
