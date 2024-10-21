package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.code.Factory.SalesManFactory;
import de.hbrs.ia.code.Factory.SocialPerformanceRecordFactory;
import de.hbrs.ia.code.ManagePersonalControl;
import de.hbrs.ia.database.MongoDBControl;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagePersonalTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;
    private MongoCollection<Document> socialPerformanceRecords;
    private SocialPerformanceRecordFactory socialPerformanceRecordFactory;
    private MongoDBControl mongoDBControl;
    private ManagePersonalControl managePersonalControl;


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
        socialPerformanceRecordFactory = SocialPerformanceRecordFactory.getInstance();
        mongoDBControl = new MongoDBControl();
        managePersonalControl = new ManagePersonalControl();


    }

    @Test
    void createSocialPerformanceRecordFromBlank() {

        // CREATE
        Document socialPerformanceRecord = new Document();

        Document leadershipCompetence = new Document();
        leadershipCompetence.append("targetValue", 4);
        leadershipCompetence.append("actualValue", 1);
        leadershipCompetence.append("bonus", 100);

        Document opennessToEmployee = new Document();
        opennessToEmployee.append("targetValue", 4);
        opennessToEmployee.append("actualValue", 2);
        opennessToEmployee.append("bonus", 200);

        Document socialBehaviourToEmployee = new Document();
        socialBehaviourToEmployee.append("targetValue", 4);
        socialBehaviourToEmployee.append("actualValue", 3);
        socialBehaviourToEmployee.append("bonus", 300);

        Document attitudeTowardsClient = new Document();
        attitudeTowardsClient.append("targetValue", 4);
        attitudeTowardsClient.append("actualValue", 4);
        attitudeTowardsClient.append("bonus", 400);

        Document communicationSkills = new Document();
        communicationSkills.append("targetValue", 4);
        communicationSkills.append("actualValue", 2);
        communicationSkills.append("bonus", 250);

        Document integrityToCompany = new Document();
        integrityToCompany.append("targetValue", 4);
        integrityToCompany.append("actualValue", 3);
        integrityToCompany.append("bonus", 350);

        socialPerformanceRecord.append("leadershipCompetence", leadershipCompetence);
        socialPerformanceRecord.append("opennessToEmployee", opennessToEmployee);
        socialPerformanceRecord.append("socialBehaviourToEmployee", socialBehaviourToEmployee);
        socialPerformanceRecord.append("attitudeTowardsClient", attitudeTowardsClient);
        socialPerformanceRecord.append("communicationSkills", communicationSkills);
        socialPerformanceRecord.append("integrityToCompany", integrityToCompany);
        socialPerformanceRecord.append("sid", 90133);

        socialPerformanceRecords.insertOne(socialPerformanceRecord);

        //READ
        Document newDocument = this.socialPerformanceRecords.find().first();
        System.out.println("Printing the object (JSON): " + newDocument.toJson());

        //assertion
        Integer sid = (Integer) newDocument.get("sid");
        assertEquals(90133, sid);


    }

    @Test
    void fullCRUD() {

        for (int sid = 0; sid < 10; sid++) {

            //CREATE
            createSalesMan(sid);
            addSocialPerformanceRecord(sid);
            //READ
            readSalesMan(sid);
            readAllSalesMen();
            readSocialPerformanceRecord(sid);
            //DELETE
            deletePerformanceRecords(sid);
            deleteSalesMan(sid);
        }

    }


    void createSalesMan(int sid) {
        SalesMan standardSalesMan = SalesManFactory.getInstance().getStandardSalesMan(sid);
        managePersonalControl.createSalesMan(standardSalesMan);

    }

    void addSocialPerformanceRecord(int sid) {
        SocialPerformanceRecord standardRecord = socialPerformanceRecordFactory.getStandardPerformanceRecord();
        SalesMan salesMan = managePersonalControl.readSalesMan(sid);

        managePersonalControl.addSocialPerformanceRecord(standardRecord, salesMan);

    }

    void readSalesMan(int sid) {

        SalesMan salesMan = managePersonalControl.readSalesMan(sid);
        assertEquals(sid, salesMan.getId());

    }

    void readAllSalesMen() {

        List<SalesMan> allSalesMen = managePersonalControl.readAllSalesMen();
        assertTrue(allSalesMen.size() > 0);

    }

    void readSocialPerformanceRecord(int sid) {
        SalesMan salesMan = managePersonalControl.readSalesMan(sid);
        List<SocialPerformanceRecord> read = managePersonalControl.readSocialPerformanceRecord(salesMan);

        assertTrue(read.size() > 0);

    }

    void deleteSalesMan(int sid) {

        managePersonalControl.deleteSalesMan(sid);
        SalesMan salesMan = managePersonalControl.readSalesMan(sid);
        assertNull(salesMan);


    }

    void deletePerformanceRecords(int sid) {
        managePersonalControl.deletePerformanceRecords(sid);
        SalesMan salesMan = managePersonalControl.readSalesMan(sid);
        List<SocialPerformanceRecord> read = managePersonalControl.readSocialPerformanceRecord(salesMan);

        assertTrue(read.size() == 0);

    }


}
