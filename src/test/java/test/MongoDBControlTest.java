package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.SocialPerformanceRecord;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MongoDBControlTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;
    private MongoCollection<Document> socialPerformanceRecords;


    /**
     * Attention: You might update the version of the Driver
     * for newer version of MongoDB!
     * This tests run with MongoDB 4.2.17 Community
     */
    @BeforeEach
    void setUp() {
        // Setting up the connection to a local MongoDB with standard port 27017
        // must be started within a terminal with command 'mongod'.
        client = new MongoClient("localhost", 27017);

        // Get database 'highperformance' (creates one if not available)
        supermongo = client.getDatabase("highperformanceNewTest");

        // Get Collection 'salesmen' (creates one if not available)
        salesmen = supermongo.getCollection("salesmen");
        socialPerformanceRecords = supermongo.getCollection("socialPerformanceRecords");

    }

    @Test
    void createSocialPerformanceRecord(){

        // CREATE
        Document socialPerformanceRecord = new Document();

        Document leadershipCompetence  = new Document();
        leadershipCompetence.append("targetValue",4);
        leadershipCompetence.append("actualValue",1);
        leadershipCompetence.append("bonus",100);

        Document opennessToEmployee  = new Document();
        opennessToEmployee.append("targetValue",4);
        opennessToEmployee.append("actualValue",2);
        opennessToEmployee.append("bonus",200);

        Document socialBehaviourToEmployee  = new Document();
        socialBehaviourToEmployee.append("targetValue",4);
        socialBehaviourToEmployee.append("actualValue",3);
        socialBehaviourToEmployee.append("bonus",300);

        Document attitudeTowardsClient  = new Document();
        attitudeTowardsClient.append("targetValue",4);
        attitudeTowardsClient.append("actualValue",4);
        attitudeTowardsClient.append("bonus",400);

        Document communicationSkills  = new Document();
        communicationSkills.append("targetValue",4);
        communicationSkills.append("actualValue",2);
        communicationSkills.append("bonus",250);

        Document integrityToCompany  = new Document();
        integrityToCompany.append("targetValue",4);
        integrityToCompany.append("actualValue",3);
        integrityToCompany.append("bonus",350);

        socialPerformanceRecord.append("leadershipCompetence",leadershipCompetence);
        socialPerformanceRecord.append("opennessToEmployee",opennessToEmployee);
        socialPerformanceRecord.append("socialBehaviourToEmployee",socialBehaviourToEmployee);
        socialPerformanceRecord.append("attitudeTowardsClient",attitudeTowardsClient);
        socialPerformanceRecord.append("communicationSkills",communicationSkills);
        socialPerformanceRecord.append("integrityToCompany",integrityToCompany);
        socialPerformanceRecord.append("sid",90133);

        socialPerformanceRecords.insertOne(socialPerformanceRecord);

        //READ
        Document newDocument = this.socialPerformanceRecords.find().first();
        System.out.println("Printing the object (JSON): " + newDocument.toJson() );

        //assertion
        Integer sid = (Integer) newDocument.get("sid");
        assertEquals( 90133 , sid );


    }
}
