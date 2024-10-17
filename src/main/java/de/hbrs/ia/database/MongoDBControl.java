package de.hbrs.ia.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBControl {

    MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("personalmanagementdb");

    MongoCollection<Document> salesmenCollection = mongoDatabase.getCollection("salesmen");
    MongoCollection<Document> performanceCollection = mongoDatabase.getCollection("socialPerformance");

    public void bulkAddSalesMen(List<SalesMan> salesMen) {
        List<Document> records = new ArrayList<>();
        for(SalesMan salesMan : salesMen) {
            records.add(salesMan.toDocument());
        }
        salesmenCollection.insertMany(records);
    }

    public void addSalesMan(Document record) {
        salesmenCollection.insertOne(record);
    }

    public void deleteSalesMan(Document record) {
        salesmenCollection.deleteOne(record);
    }

    public SalesMan getSalesManById(int sid) {
        Document searchParameter = new Document().append("sid", sid);
        Document foundSalesMan = (Document) salesmenCollection.find(searchParameter);
        if(!(foundSalesMan.get("sid") == null)) {
            return new SalesMan(foundSalesMan.getString("firstname"),
                    foundSalesMan.getString("lastname"),
                    foundSalesMan.getInteger("sid"));
        }

        return null;

    }



}
