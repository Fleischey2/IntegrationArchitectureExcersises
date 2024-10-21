package de.hbrs.ia.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.code.Factory.SalesManFactory;
import de.hbrs.ia.code.Factory.SocialPerformanceRecordFactory;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBControl {

    MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("personalmanagementdb");

    MongoCollection<Document> salesmenCollection = mongoDatabase.getCollection("salesmen");
    MongoCollection<Document> performanceCollection = mongoDatabase.getCollection("socialPerformance");

    public void bulkAddSalesMen(List<SalesMan> salesMen) {
        List<Document> records = new ArrayList<>();
        for (SalesMan salesMan : salesMen) {
            records.add(salesMan.toDocument());
        }
        salesmenCollection.insertMany(records);
    }

    public void addSalesMan(Document record) {
        salesmenCollection.insertOne(record);
    }

    public void addSocialPerformanceRecord(Document record) {
        performanceCollection.insertOne(record);
    }

    public void deleteSalesMan(int sid) {
        Bson query = eq("sid", sid);
        salesmenCollection.deleteOne(query) ;

    }
    public void deletePerformanceRecords(int sid){
        Bson query = eq("sid", sid);
        performanceCollection.deleteMany(query);

    }

    public SalesMan getSalesManById(int sid) {
        Document searchParameter = new Document().append("sid", sid);
        Document foundSalesMan = salesmenCollection.find(searchParameter).first();
        if (foundSalesMan != null) {
            return SalesManFactory.getInstance().convertFromDocument(foundSalesMan);
        }

        return null;

    }

    public List<SalesMan> getAllSalesMen() {
        FindIterable<Document> foundRecords = salesmenCollection.find();
        ArrayList<SalesMan> allRecords = new ArrayList<>();
        foundRecords.forEach(record -> allRecords.add(SalesManFactory.getInstance().convertFromDocument(record)));

        return allRecords;

    }

    public List<SocialPerformanceRecord> getSocialPerformanceRecordsBySID(int sid) {
        Document searchParameter = new Document().append("sid", sid);

        FindIterable<Document> foundRecords = performanceCollection.find(searchParameter);
        ArrayList<SocialPerformanceRecord> allRecords = new ArrayList<>();
        foundRecords.forEach(record -> allRecords.add(SocialPerformanceRecordFactory.getInstance().convertFromDocument(record)));

        return allRecords;
    }


}
