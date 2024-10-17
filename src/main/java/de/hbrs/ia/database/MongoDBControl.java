package de.hbrs.ia.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;

public class MongoDBControl {

    static MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
    static MongoClient mongoClient = new MongoClient(uri);
    static MongoDatabase mongoDatabase = mongoClient.getDatabase("personalmanagementdb");

    static MongoCollection<Document> salesmenCollection = mongoDatabase.getCollection("salesmen");
    MongoCollection<Document> performanceCollection = mongoDatabase.getCollection("socialPerformance");


}
